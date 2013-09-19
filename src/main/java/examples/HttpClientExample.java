package examples;

import java.io.*;

import java.net.*;


/**
 * Created with IntelliJ IDEA.
 * User: Кадет
 * Date: 16.09.13
 * Time: 23:13
 * To change this template use File | Settings | File Templates.
 */
public class HttpClientExample {


    public void sendPostToSpaces(String searchString) {

        String hostName = "http://spaces.ru";
        String pageUrl = "/search/?sid=0433465259137125";
        try {
            URL webUrl = new URL(hostName);
            int port = webUrl.getPort();
            if (port == -1) {
                port = 80;
            }
            System.out.println(webUrl.getHost());
            Socket socket = new Socket(webUrl.getHost(), port);

            StringBuilder data = new StringBuilder();
            data.append(URLEncoder.encode("sid", "UTF-8")).append('=').append('&');
            data.append(URLEncoder.encode("CK", "UTF-8")).append('=').append(URLEncoder.encode("585962762921929", "UTF-8")).append('&');
            data.append(URLEncoder.encode("link_id", "UTF-8")).append('=').append(URLEncoder.encode("219235", "UTF-8")).append('&');
            data.append(URLEncoder.encode("from", "UTF-8")).append('=').append('&');
            data.append(URLEncoder.encode("q", "UTF-8")).append('=').append(URLEncoder.encode("lopez", "UTF-8")).append('&');
            data.append(URLEncoder.encode("cfms", "UTF-8")).append('=').append(URLEncoder.encode("Найти", "UTF-8"));

            System.out.println("sending data: " + data);

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("POST " + "http://www.spaces.ru" + pageUrl + " HTTP/1.0");
            out.println("Host: " + "spaces.ru");
            out.println("Connection: " + "keep-alive");
            out.println("Content-Length: " + data.length());
            out.println("Cache-Control: " + "max-age=0");
            out.println("Accept: " + "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
            out.println("Origin: " + "http://spaces.ru");
            out.println("User-Agent: " + "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
            out.println("Content-Type: " + "application/x-www-form-urlencoded");
            out.println("Referer: " + "http://spaces.ru/search/?sid=0433465259137125");
            out.println("Accept-Encoding: " + "gzip,deflate,sdch");
            out.println("Accept-Language:" + "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4");
            out.println("Cookie: " + "sid=0433465259137125; __utma=168332643.1558675713.1379615216.1379615216.1379615216.1; __utmb=168332643.71.10.1379615216; __utmc=168332643; __utmz=168332643.1379615216.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
            out.println();
            out.print(data.toString());
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void showSiteTextByUrl (String hostName) {
        try {
            URL url = new URL("http://www.m-indya.com");
            InputStream inputStream = url.openStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

   /* public void sendGet (String hostName) {
        sendGet(hostName, "/");
    }

    public void sendPostToSpaces () {
        String hostName = "http://spaces.ru";
        String pageUrl = "/";
        try {
            URL webUrl = new URL(hostName);
            int port = webUrl.getPort();
            if (port == -1) {
                port = 80;
            }
            System.out.println(webUrl.getHost());
            Socket socket = new Socket(webUrl.getHost(), port);

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET " + "http://www.spaces.ru/" + " HTTP/1.0");
            out.println("Host: " + "spaces.ru");
            out.println("Connection: " + "keep-alive");
            out.println("Cache-Control: " + "max-age=0");
            out.println("User-Agent: " + "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
            out.println("Referer: " + "http://www.spaces.ru/");
            out.println("Accept-Encoding: " + "gzip,deflate,sdch");
            out.println("Accept-Language:" + "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4");
            out.println("Cookie:: " + "sid=0433465259137125; __utma=168332643.1558675713.1379615216.1379615216.1379615216.1; __utmb=168332643.3.10.1379615216; __utmc=168332643; __utmz=168332643.1379615216.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");
            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        */
    public void sendGetToSpaces() {
        String hostName = "http://spaces.ru";
        String pageUrl = "/";
        try {
            URL webUrl = new URL(hostName);
            int port = webUrl.getPort();
            if (port == -1) {
                port = 80;
            }
            System.out.println(webUrl.getHost());
            Socket socket = new Socket(webUrl.getHost(), port);

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET " + "http://www.spaces.ru/" + " HTTP/1.0");
            out.println("Host: " + "spaces.ru");
            out.println("Connection: " + "keep-alive");
            out.println("Cache-Control: " + "max-age=0");
            out.println("User-Agent: " + "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
            out.println("Referer: " + "http://www.spaces.ru/");
            out.println("Accept-Encoding: " + "gzip,deflate,sdch");
            out.println("Accept-Language:" + "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4");
            out.println("Cookie:: " + "sid=0433465259137125; __utma=168332643.1558675713.1379615216.1379615216.1379615216.1; __utmb=168332643.3.10.1379615216; __utmc=168332643; __utmz=168332643.1379615216.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)");

            /*out.println("GET / HTTP/1.1\r\n" +
                    "Host: spaces.ru\r\n" +
                    "Connection: keep-alive\r\n" +
                    "Cache-Control: max-age=0\r\n" +
                    "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,//;q=0.8\r\n" +
                    "User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36\r\n" +
                    "Accept-Encoding: gzip,deflate,sdch\r\n" +
                    "Accept-Language: ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4\r\n" +
                    "Cookie: sid=0433465259137125; __utma=168332643.1558675713.1379615216.1379615216.1379615216.1; __utmb=168332643.3.10.1379615216; __utmc=168332643; __utmz=168332643.1379615216.1.1.utmcsr=(direct)|utmccn=(direct)|utmcmd=(none)\r\n");
*/
            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
//            System.out.println("PRINTING HERE!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendToTutBy () {
        String hostName = "http://www.tut.by";
        String pageUrl = "/";
        try {
            URL webUrl = new URL(hostName);
            int port = webUrl.getPort();
            if (port == -1) {
                port = 80;
            }
            System.out.println(webUrl.getHost());
            Socket socket = new Socket(webUrl.getHost(), port);

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET " + "http://www.tut.by/" /*+ pageUrl*/ + " HTTP/1.0");
            out.println("Host: " + "www.tut.by");
            out.println("Connection: " + "keep-alive");
            out.println("Cache-Control: " + "max-age=0");
            out.println("User-Agent: " + "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36");
            out.println("Referer: " + "http://www.tut.by/");
            out.println("Accept-Encoding: " + "gzip,deflate,sdch");
            out.println("Accept-Language:" + "ru-RU,ru;q=0.8,en-US;q=0.6,en;q=0.4");
            out.println("Cookie:: " + "muid=124060570045; last_visit=1379612396; _ym_visorc=b; __utuid=detzmxw3-72jozblq-8c7hgnq6-9q9pqvv6-29dliyll; lvutm=6; __utma=108158727.331562193.1378674819.1379592357.1379611959.4; __utmb=108158727.15.10.1379611959; __utmc=108158727; __utmz=108158727.1379190475.2.2.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmv=108158727.|1=Member%20status=anonymous=1");

            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
//            System.out.println("PRINTING HERE!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendGet (String hostName, String pageUrl) {

        try {
            URL webUrl = new URL(hostName);
            int port = webUrl.getPort();
            if (port == -1) {
                port = 80;
            }
            System.out.println(webUrl.getHost());
            Socket socket = new Socket(webUrl.getHost(), port);

            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())));
            out.println("GET " + hostName + pageUrl + " HTTP/1.0");
            out.println();
            out.flush();

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);
            }

            in.close();
//            System.out.println("PRINTING HERE!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void badWorkedSendGet (String hostName, String url) {

        try {

            int port = 80;

//            String hostName = "http://www.google.by/?gws_rd=cr&ei=ru46UsyXC4e84ATt64HIBg";
            URL u = new URL(hostName);
            if (u.getPort() != -1) port = u.getPort();
            if (!(u.getProtocol().equalsIgnoreCase("http"))) {
                System.err.println("I only understand http.");
            }
            if (!(u.getFile().equals(""))) url = u.getFile();
//            String params = URLEncoder.encode("f", "UTF-8") + "=" + URLEncoder.encode("google", "UTF-8");

            Socket s = new Socket(u.getHost(), port);
            OutputStream theOutput = s.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(theOutput);
            out.write("GET " + url + "HTTP/1.0\r\n");
            out.write("Accept: text/plain, text/html, text*/\r\n");
//            out.write("Content-Type: application/x-www-form-urlencoded\r\n");
//            out.write("Content-Length: " + params.length() + "\r\n");
            out.write("\r\n");
//            out.write(params);
            out.flush();
            theOutput.flush();

            InputStream in = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (MalformedURLException ex) {
            System.err.println(hostName + " is not a valid URL");
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

/*
    public void sendPostToSpaces() {
        try {
            String host = "localhost";
            int port = 8080;
            String path = "/";
            StringBuilder data = new StringBuilder();
//            data.append(URLEncoder.encode("q", "UTF-8")).append('=').append(URLEncoder.encode("google", "UTF-8"));
//        data.append('&').append(URLEncoder.encode("NameB", "UTF-8")).append('=').append(URLEncoder.encode("NameB", "UTF-8"));

            InetAddress addr = InetAddress.getByName(host);
            Socket socket = new Socket(addr, port);
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));

            wr.write("POST " + path + " HTTP/1.0\r\n");
            wr.write("Content-Length: " + data.length() + "\r\n");
            wr.write("Content-Type: application/x-www-form-urlencoded\r\n");
            wr.write("\r\n");
// Send data
            wr.write(data.toString());
            wr.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            reader.close();
        } catch (UnknownHostException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
*/

    /*

    public void sendPostToSpaces() {

        try {
            String params = URLEncoder.encode("email", "UTF-8")
                    + "=" + URLEncoder.encode("lehaSVV2009@yandex.ru", "UTF-8");
            params += "&" + URLEncoder.encode("pass", "UTF-8")
                    + "=" + URLEncoder.encode("poshlivyvzhopu", "UTF-8");
            String hostname = "vk.com";
            int port = 80;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket socket = new Socket(addr, port);
            String path = "/feed";
            BufferedWriter wr =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            wr.write("POST " + path + " HTTP/1.0\r\n");
            wr.write("Content-Length: " + params.length() + "\r\n");
            wr.write("Content-Type: application/x-www-form-urlencoded\r\n");
            wr.write("\r\n");
            wr.write(params);
            wr.flush();
            // Get response
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        */
/*
    public void sendGet() {

        try {
            String hostname = "vk.com";
            int port = 80;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket socket = new Socket(addr, port);
            String path = "/";
            BufferedWriter wr =
                    new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF8"));
            wr.write("GET " + path + " HTTP/1.0\r\n");
            wr.write("Host: " + hostname + "\r\n");
//            wr.write("Content-Length: " + params.length() + "\r\n");
//            wr.write("Content-Type: application/x-www-form-urlencoded\r\n");
//            wr.write("\r\n");
//            wr.write(params);
            wr.flush();
            // Get response
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
*/

/*
    public void sendGoogleQuery(String searchString) {
        String hostName = "http://www.google.by/?gws_rd=cr&ei=ru46UsyXC4e84ATt64HIBg";
        int port = 80;
        String file = "/";
        try {
            URL u = new URL(hostName);
            if (u.getPort() != -1) port = u.getPort();
            if (!(u.getProtocol().equalsIgnoreCase("http"))) {
                System.err.println("I only understand http.");
            }
            if (!(u.getFile().equals(""))) file = u.getFile();
//            String params = URLEncoder.encode("f", "UTF-8") + "=" + URLEncoder.encode("google", "UTF-8");
            */
/*
            String params = URLEncoder.encode("email", "UTF-8")
                    + "=" + URLEncoder.encode("lehaSVV2009@yandex.ru", "UTF-8");
            params += "&" + URLEncoder.encode("pass", "UTF-8")
                    + "=" + URLEncoder.encode("poshlivyvzhopu", "UTF-8");
            wr.write("Content-Length: " + params.length() + "\r\n");
            wr.write("Content-Type: application/x-www-form-urlencoded\r\n");

            *//*

            Socket s = new Socket(u.getHost(), port);
            OutputStream theOutput = s.getOutputStream();
            OutputStreamWriter out = new OutputStreamWriter(theOutput);
            out.write("POST " + file + "#q=" + searchString + " HTTP/1.0\r\n");
            out.write("Accept: text/plain, text/html, text*/
/*\r\n");
//            out.write("Content-Type: application/x-www-form-urlencoded\r\n");
//            out.write("Content-Length: " + params.length() + "\r\n");
            out.write("\r\n");
//            out.write(params);
            out.flush();
            theOutput.flush();

            InputStream in = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(in);
            BufferedReader br = new BufferedReader(isr);
            int c;
            while ((c = br.read()) != -1) {
                System.out.print((char) c);
            }
        }
        catch (MalformedURLException ex) {
            System.err.println(hostName + " is not a valid URL");
        }
        catch (IOException ex) {
            System.err.println(ex);
        }

    }

    public void sendGet (String hostName) {
            int port = 80;
            String file = "/";
            try {
                URL u = new URL(hostName);
                if (u.getPort() != -1) port = u.getPort();
                if (!(u.getProtocol().equalsIgnoreCase("http"))) {
                    System.err.println("I only understand http.");
                }
                if (!(u.getFile().equals(""))) file = u.getFile();
                Socket s = new Socket(u.getHost(), port);
                OutputStream theOutput = s.getOutputStream();
                OutputStreamWriter out = new OutputStreamWriter(theOutput);
                out.write("GET " + file + " HTTP/1.0\r\n");
                out.write("Accept: text/plain, text/html, text*/
/*\r\n");
                out.write("\r\n");
                out.flush();
                theOutput.flush();

                InputStream in = s.getInputStream();
                InputStreamReader isr = new InputStreamReader(in);
                BufferedReader br = new BufferedReader(isr);
                int c;
                while ((c = br.read()) != -1) {
                    System.out.print((char) c);
                }
            }
            catch (MalformedURLException ex) {
                System.err.println(hostName + " is not a valid URL");
            }
            catch (IOException ex) {
                System.err.println(ex);
            }

    }

*/