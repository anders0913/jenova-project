package com.angelis.tera.game.network.packet.server;

import java.nio.ByteBuffer;

import com.angelis.tera.game.network.connection.TeraGameConnection;
import com.angelis.tera.game.network.packet.TeraServerPacket;

public class SM_SYSTEM_INFO extends TeraServerPacket {
    
    @Override
    protected void writeImpl(final TeraGameConnection connection, final ByteBuffer byteBuffer) {
        writeB(byteBuffer, "90800DA0E089756120432234350528509089756522053003100430068006100740043006F006E00740072006F006C006C0065007200A201D50878DABD584D881C45147E6F7F865018690691469650B69B755D63B299CC6E960A989D9D99AC4B66669B99597F1059A24EC8216A48F4A0A0E8CD1F444F426E614024C94DF1908328089E72F0E261430E39C68312C8418887F5D5DB99E9EE9DEAEEEA4922CB3474F5F77EEBABF75EED9EBB9DFC177B7DB8847007C52F6357F77C3D7E63F2D6F84F63DF4F3CBA0A7FC2DBF43B0FA7E02C7C3909706FE5F7C9E7BA39A9F695E10528419BFE5E011FAAB0090D588726D469B506DDDC3E35350CF1E9BDC9EF318055D8803592AF2401B40E0D98524F0C03DAF42C9117319FCBA47C0356E8B3A7E4F0E79768650D5AFCD6245041CDA78136E95725BD555A7B919E31869BF4BEC66ECFA9D9F8CF9BE49F0EA0D27360464D9BD2D86463258E76130EDB020BB6C023B6C0A22D70C116B8680B3C6A0B5C8ADBED0AA7BA46E00611AB9B3BA0E69238BB43F136C1CBBCCF469D6582D4F9143478B7E7D5C161508B9E0D5E5B670645F51ADDD094A8B3A7BBE1297CB2F07995DDA9B2502D8EC0DAF409D2D5CDCDAA19D3A1D0A1D4D8640A541B6AF6224F8186939F020D4A47186A2448BF468481455530C7DCEE25A6CC595CE70D08C462AA88F6BA31E0D5B4F2CC496FB32E6DA19EB4376D4EDACBB41213501F5467FFAA5C5F5DF5B889165A87B17CB748B64CDE2494EF0D8E499B88D9830050E563D58EE773008D52347F1D7D3475A34756A90FBD03EFC139E8847B516AA37918A7DA9AACF9CBE8E78CCD7519DE8033D458DF0545E5362DA0FF25F5DF4EF863C6D49729F16FC1EBEC6DC8532317EB1CFFCE9A3E3527C98D25B518072C73B1DE7141536FB768828D0A1FE212B33FA38DA8E8A22AC6899E60817E8BD82D681C0F869DD387ABDE53D4CD55D4CA688E46D558DBAE312D771CBE0FDB819AFC6BFEB891D22D781F2E10456E13592267345347CB6FF81326F5B926BC49F6D3D4864F618B0B7D13342AFF39FA9326BD4E9D8ACA7972593F3B1440C8C2C31A12BD6744CA04ED6CA3BB8D721BBD199158E01C74BF61DC7E9138503BCBEEBF2897BDA745E258ED5C41F73BD637270CB1AFF45850E28D737E45F703F9097A4F8984515C87F2A104B3C2689E34F4236D7C5A24CCD01A751D49E361613D4AF79D2808EB69C9A9682BE4CCB3227578D4EA7F46F9157A459181940313A95211C74EF7A861DCCBA0BC3B1FA37B13E555F4E68565CB70F2EE8FA877D4E8505CE718481933151D2F9D3B4CECCFD07C06C263884EEA3594D7D07B52C40C3301E490B06A46CE16BA5B28B7D05B162336256DF3079467BCE7C5487D43CBAFCB4FD1532273FB18C89E140FA08B387FA1FB987CD53B28AC9AECC0F8713162AFED1BB48E3CE83A0F22F290B69E230B2243670AA8BB5F24DC90B4A7FFA0BC88549F2C6F4A012B0F09CB1B93F337BA5372DA6CC3348AA6D830DD9FFA3DC378B6866F518185636284DB94CE5B4776A82EA4DEA9FAC11F1016372BADF716CAE3E60614BD600DB0C623317CCF1AE08D291AFE478DF30753E837B413286415389255A098556021ABC0625681A3590596028159F80F2F329D01F00101C002D22952630897565246530031004D0069006E0069006D006100700043006F006E00740072006F006C006C00650072005F00530031004D0069006E0069006D00610070004F007000740069006F006E00A2010F78DAE3389F2AC4C3880400155A0167F00101C0021152E113089756521E53003100550049005F004700460078004D0061006E006100670065007200A201B31378DA8D59DB6B5CC7199F8436984309460DC61827A8C627B8212D96E498D804576756B65696D65A6BB5D643A1EE6A77252D5EAD367BB1A2B60FA12590A73CC5B94121A57D2871FBDC167AC943A95570FE81BEB494421F1BE8430B2DA5DFF79B3967AEBB89979574CEFC66E6BBFEBE6FC6C9E9245913EB6259AC885BE2E413CF0AFA97F28FE46CF27445B4C5903E0DB14B7F39A3E7935399D8163D712006629F105DD1112371244E0A42FD50166B6CD3CC1E7D77304EA3F5FA177F970ECE1ECAE4F9E4748D46BAF46DD218FF3D10F7F1D3D9EBC5E4391B57127BB4DF80BEFC04B470D1257AD7A6711E8DA03D3D6AE21EC9D6A54F99B419895542693DBECD7A94A58BDAA2DF3DD122EC21A31E7EB4F10DD2E7D162F25C72B246BBB14558CA31EBCB7BADF12A7F903CCE96E2D9FBB0CA98C7972EDD94E9D56F3D94C96C32B3426FEF636C8475B41CC79023638BDDA659EC9591B8498831617AB03E2CFBC6B5F4ECA339E094DE7DAD7319D8217B31B0956F1F4F3F8326F9D8B20788893D68E2D99EEC54C56A1C09F1756633DE750BA836ACA5E4F2D04617D85E59633A6A135AB44294918F3C60506B34BEEB8E23E6796E0731DD57FE3BD6D17C3139B74CD27214B4841D6313F7FB7A326B662CC376635A75229E2CD3A4B7FBF419430AB6E3E1249DC91F5548C95E5BA2F1AE8E839FBF2415E25CF28CF24713F95385EF4681CED769FD263CDACB47CBACF32B32B9909C3191BF068D0790ACE7DBEE85E4EC1D8D537CC13275109B819D69D532F4642D2339F3C9E3C7D7D29D9D5319234DC46FD26A439286B36487E6107267E7114B7A8C98376B56A04B2E872FA7C1AD40F331315943C798833D937C4945C9BAC9E6DC32B4DF90BC334404EC138A73AD43BF7BAE97B40F940739F624FD7E4DAD35ABF985FCBE02DBB78B4C542B550C4F18A988B355D68EC4BC2B2FF6E2286BD19CA62D8FA37F3F8261FE1E6AEBFF6F99E55ACC92CBC985D87AD749FE9127A9B3C7CBC90B9F77DE7CC020C63B77A07D2BF48BE3431BC5756214E1A401BC38D0F54C228A4D9CBF2D390B246295A315FA3CE1F386AA407D1DABFE1E352B16AA888671CE1F161BC4BD3C014F5664FC3261B95E1816CC202747D591AE24237726C581E1B909AB93CCB7ACEA3D01457619C1225D48DB0FEC62B2B313DA6D3E391F8B03DF1F98F37DF6C49B32B752AEB59DC99B5A12277788217CDE29C357EC49C74B14CDD3EC5FA76F863CD8B7AAEE317630CCA7BA83BADB1595B52C24FB12F6EE886DBD4BBE87C559064F0C6EAAC2122CD97565BE9ABC182254948F340B3BD5A458FD537067CE13CC9CDBC462FD78BE929797B53E91DC38959C5016EDF3FB4F1EAF5D4B171652C9ECC819DDB7E760C563744C255D4FCAB4630B9E1C721DF0E267B7F05A3BE79F7F6CBC99A5FF1497ADFAC575907993FF6E05168A613668BD5DCD69B61F68FD73DFFBAA4C1F7E744DF2FAA63EB38FEF871E201FDD06A64995A7E063617991561915D9663A1ADAA9FEE0AF8BE95DF9B52CE79781D8D51DA0CFDB9B7A943D6BC5CA07EFFF394BBFFBCCD54CF5127E2448271260DBD32CD5BFB3E452F2BCB1CB1A3227C7D5C25979CC505593E206219A9A6B2CAB17B8BF2CB27FDD2C3D20DB75A2A704EE2C3ADAB6055B79DD40AC4B89F467C4FB6B90A75568C20CB80D5618067B1BDF4EEB69B7A029A32AE8A6E61123FFCD6B20ADB3AE4F255D30AE855A58B82BD30FDEFF23AC6DDB635D776526EE1CEEFA6956E863CF92C0DCC30E03FA6D2CAE72A50ABF755CAEC5F8ACAED5611E546075C546510EA2D8ABC12B7907A4F433113E9BA92ED0C654510B5B2103EA8C757BD279B723A26EC7F562500F8ABD7F25D5A943453DEBACBB27AFCBF6A53B000737C912918E20D08673EFB518D2E18792E1286F3535D282676C7B0F83FA1F9EB6AA98AB72E7D0D2FC43DD15AA8EA2A64F73F979B6A72C2FFCEEC2476F6889552E3B788A58D70A5318D3F0035924DF6589ACDB8E9D0450D50CAB76429B11825966039ADC9BB08639775421CD1EA2E8C12FB2F4D1ABBF5E0CBDCE7BAA982FE2DCABFE799E95A0D70851D745240F26D74654E0C9F3A227FE77D85ABF441534FD91771A32F940B5A186F82E7A4B3BAFA9CA6ED87DA73D461162735C0339C7B7240D1D917EA4FAE812E409EE05707FA0F86A13FD50DB7446BCFFA7CC5FEF48EEEF968A88E19E675CD8D0EF4A5E4F652AFF73089BB81526642501943A2D04F665397F22E974780CB6B14F874A527DC3F3335EE93DF0F7AA8E23C5233DFB1E08A8DFE32CBD5A44DB01641F590815F92C7705F1A66A9AAE9EF507EF82CF33BE21886114BF35ED6EB78F1CCF9405C73A9F7B3A5FC7E8B6E37DDD25C9916CE6A8FE35E7FD403ADBAB4BC9E5CF3B6F8AC4A4A35DB35467D9F56F41EC28A52A27513BB98332FE7222CAE905F293C8263C7E80D86AE4B533AF34B4AAABCD1436A1DA69B8B19DDF979971D229BE96ED0FC707C49EEE8C1A74E9C312136791E77C9DAE6B463912536E5B9D5ECEB6F306BA498FF13ECC94DD710A9F364BF119DFCCEE06374BABF017D791DC723E43183F718FD72C72CBF11259DE3EBF36F2F1DFF2F8C792EF32EAB84F0A7897641817231DA3DFC237E7B2F45F3367903B66AED24559BDAC39C9BA41B5AA647C4E1596096E8B480A83CFCF48A64A57B5147DB2A6BA0BBCA5FBEC1DF41F0DB7A658BC6D56357C53D3DD41DBADB90EBA829F6D7436053AB8EF28890937C9E7A5626E3AD395F2AEC0BED5C28DB07A6F5744EF76C0EA06CC88E5C7A0236CA3339A78274756BEA34F8907A663301C22FDF386B90B01EAE34CF5EADEDD81414D909FA23883D787B84D6A13770FF45CE02EF03DEA5750836BE0C34E943B542FA3727E80FDEC1B3CB79B56FF9B60E471B8C2439570921C41B68EF88ECD6C657373B84FBBDD15F14C9F2F78646D2FFD4CF4C542B3BFBDFC83CCA0FB05DABE8B9EB338EAEFD967ADBD50A0EBF52DA9F823C7E57C54A1F917819BA50EEACA5B6F659371D8BD3E47B82FFFE9C75370CA022708F7A3DFF433E69B09F708A85207FAECC9113AE556DCE9CC8F30BE073FB297DACEFD89BA29BE81A8E2FEE268F25914FF1F96F7BCCC29CBC5AD42785E1E60F70E45C83E45DF187B071C8AD37C0367FDA02E999306F238C38A3D7D3F6DD90798D71755AE184CC3BE4130DC266766921375B2CA8AB823669E9A237F5E14F9BBDBE266F0AE2656CDBBA7999536C94234F749F5BC4E5EACD17E334FCE610E3F671463F69C8C5837A379F91C7E5EC29C7CCD2D9A619E57085D72C6D7F51E065FEC7932496ED0EC9A83A8D06E9720E55CF17CD97BBEE23D4BEF79C579E68F59FF368D5BCF4FB1A54A62E60B572CCB95A8CEF9D6AC90E6FEBBF5A827EA114F9422EB55827719CBE5BD2BD3D77F57A2F8F5DF55D94B016E23782723EB5D8FBCDB8AD8602B2273356297654286B26C45E686FA6E527C85F68BCDAD466C558DE05622F2197F9C16FF0738BEF1F6F00101C002AA3F");
    }
}
