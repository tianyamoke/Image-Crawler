import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Created by cayley on 2019/7/23.
 */
public class VeryIns {

    public static void main(String[] args) {

    }

    public static void parseSomething(String id) throws Exception{
        Document doc = Jsoup.connect("https://www.veryins.com/"+id).userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").timeout(10000).get();

    }

}
