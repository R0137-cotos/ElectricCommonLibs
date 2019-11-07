package jp.co.ricoh.cotos.electriccommonlib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ricoh.cotos.commonlib.entity.EntityBase;

@Component
public class TestCheckComponent {

	/**
	 * 
	 * 計上実績.RJ粗利金額
	 */
	@Transactional
	public <T extends CrudRepository<U, Long>, U extends EntityBase> void update(CrudRepository<U, Long> repository, U entity) {
		repository.save(entity);
	}
}
