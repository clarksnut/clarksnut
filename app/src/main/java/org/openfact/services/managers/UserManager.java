package org.openfact.services.managers;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.rest.RestStatus;
import org.openfact.models.FileModel;
import org.openfact.models.FileProvider;
import org.openfact.models.ModelException;
import org.openfact.models.utils.DocumentUtil;
import org.openfact.services.resources.ElasticsearchConfig;
import org.w3c.dom.Document;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Stateless
public class UserManager {

    @Inject
    private ElasticsearchConfig elasticsearchConfig;

    @Inject
    private DocumentUtil documentUtil;

    @Inject
    private FileProvider fileProvider;

    public IndexResponse importDocument(Document document) {
        // Persist xml file
        byte[] bytes;
        try {
            bytes = getBytesFromDocument(document);
        } catch (Exception e) {
            throw new ModelException("Could not transform document to byte[]");
        }

//        FileModel file = fileProvider.addFile(bytes);
//
//        // Persist json
//        XContentBuilder json = documentUtil.read(document);
//        IndexResponse response = null;
//        try {
//            response = elasticsearchConfig.getClient()
//                    .prepareIndex("index", "type")
//                    .setSource(json.field("fileId", file.getId()))
//                    .get();
//        } catch (IOException e) {
//            throw new ModelException("Could not add fileId field", e);
//        }

        return null;
    }

    private byte[] getBytesFromDocument(Document document) throws Exception {
        Source source = new DOMSource(document);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Result result = new StreamResult(out);
        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.transform(source, result);
        return out.toByteArray();
    }
}