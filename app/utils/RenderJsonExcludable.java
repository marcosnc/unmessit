package utils;

import models.ClientComment;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import play.exceptions.UnexpectedException;
import play.mvc.Http.Request;
import play.mvc.Http.Response;
import play.mvc.results.Result;

public class RenderJsonExcludable extends Result {

	public static void renderJsonExcludable(Object o){
		throw new RenderJsonExcludable(o);
	}
	
    private String json;

    public RenderJsonExcludable(Object o) {
        json = getGson().toJson(o);
    }

    private static Gson gson;
	private static Gson getGson() {
		if( gson==null ){
			gson = new GsonBuilder()
			.setExclusionStrategies(new ExclusionStrategy() {
				@Override
				public boolean shouldSkipField(FieldAttributes fieldAttributes) {
					return fieldAttributes.getAnnotation(ExcludeFromJson.class)!=null;
				}
				@Override
				public boolean shouldSkipClass(Class<?> clazz) {
					return false;
				}
			})
			.serializeNulls()
			.create();
		}
		return gson;
	}

	@Override
	public void apply(Request request, Response response) {
        try {
            String encoding = getEncoding();
            setContentTypeIfNotSet(response, "application/json; charset="+encoding);
            response.out.write(json.getBytes(encoding));
        } catch (Exception e) {
            throw new UnexpectedException(e);
        }
	}

}
