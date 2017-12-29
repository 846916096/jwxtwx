package cn.Test.MINA;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyProtocalClient {
    // mina编解码流程：request->MyDecoder->MyHandler->MyEncode->response
    // 对于长度>1000字节的数据包采用分段发送。
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 8080);
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);
            for (int i = 0; i < 200; i++) {
                long startTime = System.currentTimeMillis(); // 获取开始时间
                String str = "2BC0A039329D8FF6F4CB8BAA71A45FED8E119BEB76F0F1B1AA99F73B867C1685AF0F903F10F65505A4D618E30C0A1A9046FF3301A368AD36A7ADC78761E6C4C758D2611F3F3E3C448E63CE1B2CA88ACF7C54F44AC3621D927C16E5C4876FFDF51392FF7BFE8392420B6125504F53AB5C5CB1C350EA67BE577B6DB689F63C47B5F5593C55B607667240A57DF820109A13194C42AA1F3205771AB9E3C359555BC973FF59DD752E19CB472B61D8FA910A0C820A2677A2032723A00E87079F0A79BB9ACA930EBF7F25BC31AA7E1DA70810FC2ABA508269185FC6306082E966D82464CBF07B77502962EE378629C74B26BD3B536CDAA049D3841B36B7B7A4E9EC95CDE330ABFCD594DF4FAE3DEEB99DBC8DDA054F4D6B0F0EAEE82A21771A92635CAD9FFE021A2A408BC7C40060CCA98C77FEB8A7F5BC8AD5A64CF58BC0D5C9ED56D1E2450A2A674E53093BC015E2CEFC1D9B6B8BC79B85868C47586632DDEA08ED9EEE31A4DC9D777C28AD65892E1C5E1260AFF9299E162FE3276CF1A0FAD89878FF89ACEFF48C2B0FCD07E272C834F0C07C1838A39F019D1184232688F40AC0AE2F302B8F20A12F7D7511042E7B68E0C07D3B94CC61609097B9B7062B9DEE91E73DCDD268CBD247DB2348311A4EC1A7CAA554287C464F751960624236313976D16B5C735F1083FD18CC1FB56614A3B9B7F32249A38FD1A6EF235369E2311D6C964F2D459C75EA732BD1F3095BB2DA5821655974E1A53E5EBDA47652000D563F52A48CA00F395EDAEC58EEBE8D46C57886F8C5811E6C8F5A979DE911249F07370FB8BEF8BB35E0E64608EC43581DFBFEABE6C11337FD05DCBDC9242EBFD42D82DD59D72682D3C94945FEB03051153863CD3556E6B87BABCF1A5B01698D459FD01CFB7C28C650E0A8FE575C8E380601D55E517DF5852F07A49CF982635FA1E4689AF1D9B94F02D8F00B4AED356401FF6FFC1FC73C99D3025C08096FEF6659F32EA4D53279FAC697D56339F1A5F689E806F0F900A09A8F4CDB64B5DACEF7D6DC06460217234794DB61CC5AD6E8534B4BA5FB3B38B8D195E3B71AEBA4983606E00ECDC644CFFC5696140C78767139B3806C68F4906810030BC23DFE91C1C8CD11F758CCB3E4BCFD254B5D3959EC7F7764CE76DB74E117E7F844ADA94F99B02AC961A87C3084358D6B64540898788BDAA8455F374B607C7ACAB489BE099AB7C7AD78EFF8C1405A90DDAF23EB5D454167178620458227922B8A8E9E1D8D980089FBFC8143BA8FFD96E49A18C32BAEFB088956A75192805D44C5C2BFB345D6FA54A74C8B8B6BD566F24DB3BAB58F71BDB03807A566DEFCAC57889F2CE4803B39D64AF61291D3C56A5C0B4F3C3E287CAD8540505E23A24EA2D4815A742ED7F9173F8C157735B8D7FA20727E013E5BEECEF3DAC27960E7BA025D5335952AC1C0CBB94523835574FCB1E5B5E1782FC1EFA9B0471F3D443F6104C13698929D2FCE5B2220BF9DCD125CA8F8918826A48F960CEE66E01AB5F066630E1793277838E0F997D8C8A01C086387BB2718C7CA1A1C3BB46223CE0B367DD86DCA768D50F41BB40188709103D2C854044DE2653002EEB78965D8141B5A6900B17A94A6846CA2595436E45DA841F6DC3165187DAF6499DB5B15233A7205D9CB70D8776F109C6B744A0DA3ADC4EABEFA6C83C28BC2BC4C3389CF792F1AC9B544290D1A5C0CCBD69E89183A08A5B2496398358A6005FD404EF89678BE00FA0034C192D5B089A92083F93C5E8A8E36367A9DA75B463A6566806FACB47E71C4276F45D294CE54E7292DBD092E8D6D74C474D49D94BA5594090EDD12AC06DE72DDEC2AB56AD94C";
                String temp_ = "";
                int SUB_COUNT = 1000;// 按1000个字节来截取字符串
                // 发送数据包长度
                out.writeInt(2608 + 8);
                // 分段来发送数据
                for (int c = 0; c < str.getBytes().length / SUB_COUNT; c++) {
                    if (temp_ == "" && temp_.length() == 0) {
                        temp_ = str.substring(c * SUB_COUNT, SUB_COUNT);
                        // 发送第一次也是第一段数据
                        out.write(temp_.getBytes());
                    } else {
                        // 按1000个字节分段发送数据
                        out.write(str.substring(c * SUB_COUNT, (c + 1) * SUB_COUNT).getBytes());

                        // 发送剩余的不足1000个字节的数据串
                        int raim_ = str.substring((c + 1) * SUB_COUNT, str.getBytes().length).length();
                        if (raim_ < SUB_COUNT && raim_ != 0) {
                            out.write(str.substring((c + 1) * SUB_COUNT, str.getBytes().length).getBytes());
                        }
                    }
                }
                // 马上写入，释放缓存
                out.flush();
                System.out.println(i + " sended");

                char temp[] = new char[2700];
                String backLine = "";
                in.read(temp);
                backLine = String.valueOf(temp).trim();
                System.out.println("backLine==" + backLine);
                long endTime = System.currentTimeMillis(); // 获取结束时间
                System.out.println("程序运行时间(毫秒)： " + (endTime - startTime) + "ms");
            }
            Thread.sleep(1000);
            out.close();
            in.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}