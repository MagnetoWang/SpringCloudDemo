//package start.integration.data;
//
//
//import com.rometools.rome.feed.synd.SyndEntryImpl;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.integration.endpoint.SourcePollingChannelAdapter;
//import org.springframework.integration.support.MessageBuilder;
//import org.springframework.messaging.MessageChannel;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileReader;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest({ "auto.startup=false",      // we don't want to start the real feed
//        "feed.file.name=Test" })   // use a different file
//public class FlowTests {
//
////    @Autowired
////    private SourcePollingChannelAdapter newsAdapter;
////
////    @Autowired
////    private MessageChannel news;
////
////    @Test
////    public void test() throws Exception {
//////        assertThat(this.newsAdapter.isRunning()).isFalse();
////        SyndEntryImpl syndEntry = new SyndEntryImpl();
////        syndEntry.setTitle("Test Title");
////        syndEntry.setLink("http://foo/bar");
////        File out = new File("/tmp/si/Test");
////        out.delete();
//////        assertThat(out.exists()).isFalse();
////        this.news.send(MessageBuilder.withPayload(syndEntry).build());
//////        assertThat(out.exists()).isTrue();
////        BufferedReader br = new BufferedReader(new FileReader(out));
////        String line = br.readLine();
//////        assertThat(line).isEqualTo("Test Title @ http://foo/bar");
////        br.close();
////        out.delete();
////    }
//
//}