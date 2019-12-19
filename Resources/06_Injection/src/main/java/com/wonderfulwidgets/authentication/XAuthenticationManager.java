// XAuthenticationManager.java
// Copyright © 2019-2020 NextStep IT Training. All rights reserved.
//

package com.wonderfulwidgets.authentication;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.text.html.parser.Parser;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XAuthenticationManager implements IAuthenticator {

    public boolean authenticate(String username, char[] password) {

        boolean result = false;
        MD5Hasher hasher = new MD5Hasher();

        try {

            FileInputStream fileIS = new FileInputStream(this.getFile());
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(fileIS);
            XPath xPath = XPathFactory.newInstance().newXPath();
            String expression = buildSearchExpression(username, hasher.hash(password));

            System.out.println(expression);

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(xmlDocument, XPathConstants.NODESET);

            result = (nodeList.getLength() == 1);
        }

        catch (Exception e) {

            // Log the problem before we consider the exception handled.
        }

        return result;
    }

    String buildSearchExpression(String username, String hashedPassword) {

        return "/identities/identity[name/text()='" + username + "' and password/text()='" + hashedPassword + "']";
    }

    File getFile() {

        // This should really come form external configuration via a properties file, etc.

        return new File("identity-map.xml");
    }
}
