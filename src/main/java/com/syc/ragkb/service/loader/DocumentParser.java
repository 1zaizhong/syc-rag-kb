package com.syc.ragkb.service.loader;

import java.io.InputStream;

/**
 * @author 粟英朝
 * @version 0.0.3
 * @date 2026/4/29 下午4:11
 * @description 文档解析器,具体解析器各种实现
 **/
public interface DocumentParser {
    //支持的文件类型(大写) 比如:PDF,DOCX,PPTX,TXT
    String supportedType();

    //解析文件返回解析结果
    ParseResult  parse (InputStream inputStream, String fileName);
}
