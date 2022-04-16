package fh.dortmund.backend.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.URISyntaxException;

@Service
public class HttpGenerator {

    @Value("${corona-datenplattform.token}")
    private String token;

    @Value("${corona-datenplattform.basicURL}")
    private String basicURL;

    private String resourceId="resource_id=";

    private String limit="limit=";

    public HttpHeaders getHeaderWithToken(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token );
        return headers;
    }

    public URI generateURIWithLimitAndResourceId(int limit, String resourceId) throws URISyntaxException {
        return new URI(basicURL+this.limit+limit+"&"+this.resourceId+resourceId);
    }

}
