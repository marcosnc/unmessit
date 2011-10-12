package jobs;

import java.util.Date;

import models.Client;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class BootstrapJob extends Job {

	@Override
	public void doJob() {
		// Remove all data
		Fixtures.deleteDatabase();

		// Load data from test yml file
		Fixtures.loadModels("test-data.yml");
		
		// Add extra random data
		for(int i=0; i<100; i++){
			Client client = new Client();
			client.surname = String.format("Client Surname-%2d", i);
			client.name    = String.format("Name-%2d", i);
			client.createdOn = new Date();
			client.save();
		}
	}
	
}