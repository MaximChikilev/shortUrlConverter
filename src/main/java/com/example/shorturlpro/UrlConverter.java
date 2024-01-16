package com.example.shorturlpro;

import com.google.common.net.InternetDomainName;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
@Component
public class UrlConverter {
    public String convertToShortUrl(String urlString) throws URISyntaxException {

        URI uri = new URI(urlString);
        String host = uri.getHost();
        InternetDomainName internetDomainName = InternetDomainName.from(host).topPrivateDomain();
        String domainName = internetDomainName.toString();
        String publicSuffix = internetDomainName.publicSuffix().toString();
        String name = domainName.substring(0, domainName.lastIndexOf("." + publicSuffix));
        long currentTimeMillis = System.currentTimeMillis();
        return name+currentTimeMillis/1000;
    }
}
