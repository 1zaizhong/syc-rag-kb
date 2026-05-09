package com.syc.ragkb.service.loader;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/29 下午3:35
 * @description 数据结构:解析结果(成功/失败  +页面列表)
 **/
@Data
@Builder
public class ParseResult {
    //解析是否成功
     private  boolean success;

     //错误信息,success==false时返回
    private  String errorMsg;


    /** 解析出的页面列表（PDF 按页，其他格式整体算一页） */
    private List<PageContent> pages;

    /** 文档总页数 */
    private int totalPages;

    /** 文档标题（如果能识别） */
    private String title;

    @Data
    @Builder
    public  static class   PageContent{
        //页码
        private  int pageNum;

        //页面内容(纯文本)
        private  String text;

        //该页面识别到的章节标题(可能为null)
        private  String sectionTitle;
    }


    public static ParseResult failure(String errorMsg) {
        return ParseResult.builder()
                .success(false)
                .errorMsg(errorMsg)
                .pages(List.of())
                .build();
    }
    //获取1所有页的合并文本
    public String getFullText(){
        if(pages == null) return " ";
        return  pages.stream()
                .map(PageContent::getText)
                .filter( t -> t !=null && !t.isBlank())
                .reduce("",(a,b) -> a + "\n\n"+ b)
                .strip();
    }
}
