package com.lovo.api.bean;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
@NoArgsConstructor
public class UserBean {

        private String id;
        private String name;
        private String pass;
}
