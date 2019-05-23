package beans;
import java.util.*;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.tone_analyzer.v3.model.DocumentAnalysis;
import com.ibm.watson.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.tone_analyzer.v3.model.ToneScore;

import Services.SingletonTraductor;
import Services.Traductor;

/*
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.DocumentAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneInput;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;*/

@SuppressWarnings("deprecation")
public class AnalizadorSentimientos {

		//"uZHTkqzfwN4B56ccQQRawh4jUb99UA-Ah6tmtrItvuli"
		private IamOptions options;
		private ToneAnalyzer toneAnalyzer;
		private String apiKey = "Mw45d_bcIdMzP3WtP2-0DLREEiykjaorvCqMGOcqPoN9";
		
		public AnalizadorSentimientos () {
			options = new IamOptions.Builder().apiKey(apiKey).build();
			toneAnalyzer = new ToneAnalyzer("2017-09-21", options);		
			toneAnalyzer.setEndPoint("https://gateway.watsonplatform.net/tone-analyzer/api");		
		}
		
		public List<ToneScore> analizar(String pComentario) {
			String text = pComentario;		
			List<ToneScore> TonosSeleccionados= null;
			
			if(!pComentario.isEmpty()) {
				
				Traductor traductor= SingletonTraductor.getInstance();
				text= traductor.traducirTexto(text);			
				ToneOptions toneOptions = new ToneOptions.Builder().text(text).acceptLanguage("es").build();			
				//ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute();
				ToneAnalysis toneAnalysis = toneAnalyzer.tone(toneOptions).execute().getResult();
				DocumentAnalysis documentAnalysis= toneAnalysis.getDocumentTone();	
				TonosSeleccionados= documentAnalysis.getTones();		
			}				
			
			return TonosSeleccionados;		
		}
		
		public int contarComentariosSentimiento(ArrayList<String> pComentarios,String pSentimiento) {		
			int cantidadDeComentarios=0;
			for (int i = 0; i < pComentarios.size(); i++) {			
				List<ToneScore> tonosComentario= analizar(pComentarios.get(i));
				
				for (ToneScore tonoComentario : tonosComentario) {
					if (tonoComentario.getToneName().equalsIgnoreCase(pSentimiento)) {
						cantidadDeComentarios++;
					}
				}
			}		
			return cantidadDeComentarios;
		}
		
		public ArrayList<String> obtenerComentariosSentimiento(ArrayList<String> pComentarios,String pSentimiento) {		
			ArrayList<String> comentariosValidos= new ArrayList<>();
			for (int i = 0; i < pComentarios.size(); i++) {			
				List<ToneScore> tonosComentario= analizar(pComentarios.get(i));
				for (ToneScore tonoComentario : tonosComentario) {
					if (tonoComentario.getToneName().equalsIgnoreCase(pSentimiento)) {
						comentariosValidos.add(pComentarios.get(i));
					}
				}
			}		
			return comentariosValidos;
		}
	

}
