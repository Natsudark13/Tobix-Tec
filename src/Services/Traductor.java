package Services;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;

public class Traductor {
	private String apikey = "0EhGxmoECIjq3zeN7em9a89neVqwTcrevrBy2bXv_Qoe";
	private String url = "https://gateway.watsonplatform.net/language-translator/api";
	
	public String traducirTexto(String textoATraducir) {
		
		IamOptions options = new IamOptions.Builder()
			    .apiKey(apikey)
			    .build();

			LanguageTranslator languageTranslator = new LanguageTranslator("2018-05-01", options);

			languageTranslator.setEndPoint(url);
			
			TranslateOptions translateOptions = new TranslateOptions.Builder()
					  .addText(textoATraducir)
					  .modelId("es-en")
					  .build();

					TranslationResult result = languageTranslator.translate(translateOptions)
					  .execute().getResult();

			String temp = result.getTranslations().get(0).toString();

			//System.out.println(result.toString());
			JsonParser parser = new JsonParser();
		    JsonObject json = (JsonObject) parser.parse(temp.toString());
		    		    
		    return json.get("translation").toString().replaceAll("^\"|\"$", "");
					
					
	}
}
