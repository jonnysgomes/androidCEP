package com.fractal;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.SimpleXmlHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HelloAndroidActivity extends Activity {

	private static String TAG = "androidCEP";
	
	private EditText cep;
	
	private EditText endereco;
	private EditText bairro;
	private EditText cidade;
	private EditText uf;
	
	private Handler handler;
	
	/**
	 * Called when the activity is first created.
	 * 
	 * @param savedInstanceState
	 *            If the activity is being re-initialized after previously being
	 *            shut down then this Bundle contains the data it most recently
	 *            supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
	 *            is null.</b>
	 */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.i(TAG, "onCreate");
        setContentView(R.layout.main);
        
        handler = new Handler();
        
        cep = (EditText) findViewById(R.id.cep);
        
        endereco = (EditText) findViewById(R.id.endereco);
        bairro = (EditText) findViewById(R.id.bairro);
        cidade = (EditText) findViewById(R.id.cidade);
        uf = (EditText) findViewById(R.id.uf);
    }
	
	public void callWebservice(View view) {
		if (!cep.getText().toString().equals("")) {
			new NetworkTask().execute();
		} else {
			Toast.makeText(this, "Digite um CEP", Toast.LENGTH_LONG).show();
		}
	}

	public void updateView(final Endereco resultCep) {
		if (resultCep != null) {
			handler.post(new Runnable() {
				public void run() {
					endereco.setText(resultCep.getTipo_logradouro() + " " + resultCep.getLogradouro());
					bairro.setText(resultCep.getBairro());
					cidade.setText(resultCep.getCidade());
					uf.setText(resultCep.getUf());
				}
			});
		}
	}

	private class NetworkTask extends
			AsyncTask<Void, Void, Endereco> {
		
		public NetworkTask() {
			super();
		}

		@Override
		protected Endereco doInBackground(Void... params) {
			RestTemplate restTemplate = new RestTemplate();

            List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
            messageConverters.add(new SimpleXmlHttpMessageConverter());
            restTemplate.setMessageConverters(messageConverters);

            restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

            final String urlCEP = "http://cep.republicavirtual.com.br/web_cep.php?cep={cep}&formato=xml";

            Endereco result = restTemplate.getForObject(urlCEP, Endereco.class, cep.getText());
            
			return result;
		}
		
		@Override
		protected void onProgressUpdate(Void... values) {
			super.onProgressUpdate(values);
		}

		@Override
		protected void onPostExecute(Endereco result) {
			super.onPostExecute(result);
			updateView(result);
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}
	}
}
