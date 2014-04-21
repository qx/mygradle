package com.cfz.android.mode.object;

import java.util.List;

/**
 * Base product information
 */
public class Product {
    /**
     * product for checkout last users that lucky;
     */
    protected int type_id;
    protected long id;
    protected String produceName;
    protected String url_img;
    protected List<Comment> commentList;
    protected int price;
    /**
     * action number
     */
    protected int id_action;
}
