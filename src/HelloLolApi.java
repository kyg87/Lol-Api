import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class HelloLolApi {

	public static void main(String[] args) throws MalformedURLException, IOException  {
		// TODO Auto-generated method stub
			String sumonnerNames = JOptionPane.showInputDialog("Digite seu name");
			
			
			
			URL lolApiSite = new URL("https://kr.api.riotgames.com/api/lol/KR/v1.4/summoner/by-name/"+ sumonnerNames +"?api_key=RGAPI-133cfc7a-22f3-4eef-83f5-2c7ca3d3a5d6");
	
			BufferedReader in = new BufferedReader(new InputStreamReader(lolApiSite.openStream()));
			
			String lolApiJson = in.readLine();
			System.out.println(lolApiJson);
			
			JSONObject lolApi = new JSONObject(lolApiJson);
		
			int id = lolApi.getJSONObject(sumonnerNames).getInt("id");
			String name = lolApi.getJSONObject(sumonnerNames).getString("name");
			int summonerLevel = lolApi.getJSONObject(sumonnerNames).getInt("summonerLevel");
		
			
			System.out.println(id);
			System.out.println(name);
			System.out.println(summonerLevel);
			
			
			URL revisionDateURL = new URL("https://kr.api.riotgames.com/api/lol/KR/v1.4/summoner/"+id+"?api_key=RGAPI-133cfc7a-22f3-4eef-83f5-2c7ca3d3a5d6");
			
			BufferedReader ina = new BufferedReader(new InputStreamReader(revisionDateURL.openStream()));
			
			String lolApiJsona = ina.readLine();
			System.out.println(lolApiJsona);
			
			JSONObject lolApia = new JSONObject(lolApiJsona);
			
			String _id = Integer.toString(id);
			long revisionDate = lolApia.getJSONObject(_id).getLong("revisionDate");
	

			String dateFormatStringTime;
			
			Date currentDate = new Date(System.currentTimeMillis());
			Date date1 = new Date(revisionDate + 60*60*7*1000);


			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
			dateFormatStringTime = dateFormat.format(currentDate);
			System.out.println(dateFormatStringTime);
			
			dateFormatStringTime = dateFormat.format(date1);
			System.out.println(dateFormatStringTime);
		
			
			URL currentInGameURL = new URL("https://kr.api.riotgames.com/observer-mode/rest/consumer/getSpectatorGameInfo/KR/"+id+"?api_key=RGAPI-133cfc7a-22f3-4eef-83f5-2c7ca3d3a5d6");
	
			
			BufferedReader ino = new BufferedReader(new InputStreamReader(currentInGameURL.openStream()));
			
			
			String lolApiJsonao = ino.readLine();
			
			JSONObject lolApiao = new JSONObject(lolApiJsona);
			System.out.println(lolApiJsonao);
			//dateFormatStringTime = dateFormat.format(System.currentTimeMillis()-revisionDate + 60*60*7*1000);
			
	/*		long mills = System.currentTimeMillis() - revisionDate + 60*60*7*1000;
			
			
			System.out.println((mills/1000)/60);*/
			
		
			long gameStartTime = lolApiao.getLong("gameStartTime");
			System.out.println(gameStartTime);
	}

}
