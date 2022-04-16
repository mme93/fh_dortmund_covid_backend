package fh.dortmund.backend.utility;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;

@Service
public class CoronaJSON {

    private final HttpGenerator httpGenerator;

    @Autowired
    public CoronaJSON(HttpGenerator httpGenerator) {
        this.httpGenerator = httpGenerator;
    }

    public JSONArray getJSONArrayFromGetRequest(int limit, String ressource_id) throws URISyntaxException {
        String json = new RestTemplate().exchange(this.httpGenerator.generateURIWithLimitAndResourceId(limit, ressource_id),
                HttpMethod.GET,
                new HttpEntity(this.httpGenerator.getHeaderWithToken()), String.class).getBody();
        JSONObject jsonObject = new JSONObject(json);
        jsonObject = jsonObject.getJSONObject("result");
        return jsonObject.getJSONArray("records");
    }

}
