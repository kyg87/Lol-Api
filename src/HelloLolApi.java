import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

import org.json.JSONObject;

public class HelloLolApi {

	public static void main(String[] args) throws MalformedURLException, IOException  {
		// TODO Auto-generated method stub
			String somonnerNames = JOptionPane.showInputDialog("Digite seu name");
			
			
			
			URL lolApiSite = new URL("https://kr.api.riotgames.com/api/lol/KR/v1.4/summoner/by-name/"+ somonnerNames +"?api_key=RGAPI-133cfc7a-22f3-4eef-83f5-2c7ca3d3a5d6");
	
			BufferedReader in = new BufferedReader(new InputStreamReader(lolApiSite.openStream()));
			
			String lolApiJson = in.readLine();
			System.out.println(lolApiJson);
			
			JSONObject lolApi = new JSONObject(lolApiSite);
			
			String name = lolApi.getJSONObject(somonnerNames).getString("name");
			String summonerLevel = lolApi.getJSONObject(somonnerNames).getString("summonerLevel");
			String id = lolApi.getJSONObject(somonnerNames).getString("id");
			
			System.out.println(name);
			System.out.println(summonerLevel);
			System.out.println(id);
			
	
	}

}
