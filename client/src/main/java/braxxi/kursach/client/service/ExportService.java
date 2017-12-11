package braxxi.kursach.client.service;

import braxxi.kursach.commons.entity.EstateEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class ExportService {

	public void saveEstates(List<EstateEntity> entities, File toFile) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(toFile, entities);
	}

}
