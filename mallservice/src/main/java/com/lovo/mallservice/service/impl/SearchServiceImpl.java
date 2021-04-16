package com.lovo.mallservice.service.impl;

import com.lovo.api.bean.skuBean;
import com.lovo.mallservice.service.SearchService;
import io.searchbox.client.JestClient;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    JestClient jestClient;

    @Override
    public List<skuBean> getList(String search) {
        // jest的dsl工具
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        // bool
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        // must
        if (StringUtils.isNotBlank(search)) {
            MatchQueryBuilder matchQueryBuilder = new MatchQueryBuilder("name", search);
            boolQueryBuilder.must(matchQueryBuilder);
        }

        // query
        searchSourceBuilder.query(boolQueryBuilder);
        // highlight
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags("<span style='color:red;'>");
        HighlightBuilder a = highlightBuilder.field("name");
        highlightBuilder.postTags("</span>");
        searchSourceBuilder.highlight();


        String dslStr = searchSourceBuilder.toString();
        System.err.println(dslStr);


        List<skuBean> skuBeanList = new ArrayList<>();
        Search search1 = new Search.Builder(dslStr).addIndex("mall2020").addType("AllSKU").build();
        SearchResult execute = null;

        try {
            execute=jestClient.execute(search1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<SearchResult.Hit<skuBean, Void>> hits = execute.getHits(skuBean.class);

        for (SearchResult.Hit<skuBean, Void> hit : hits) {
            skuBean source = hit.source;

            Map<String, List<String>> highlight = hit.highlight;
            if (highlight != null) {
                String skuName = highlight.get("name").get(0);
                source.setName(skuName);
            }
            skuBeanList.add(source);
        }

        System.out.println(skuBeanList.size());
        return skuBeanList;
    }
}
