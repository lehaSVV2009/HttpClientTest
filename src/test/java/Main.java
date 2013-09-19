import examples.HttpClientExample;

/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 16.09.13
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main (String []args) {
        HttpClientExample httpClientExample = new HttpClientExample();
        System.out.println("\n\n\n");
//        httpClientExample.sendGet("http://www.tut.by/", "/");
//        httpClientExample.sendPostToSpaces();
//        httpClientExample.sendToTutBy();
//        httpClientExample.sendGetToSpaces();
        httpClientExample.sendPostToSpaces("q");
//        httpClientExample.showSiteTextByUrl("http://www.tut.by");
    }


}
