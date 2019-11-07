package jp.co.ricoh.cotos.electriccommonlib.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import jp.co.ricoh.cotos.commonlib.entity.EntityBase;

@Component
public class TestCheckComponent {

	/**
	 * Repository.save実行メソッド
	 * 
	 * @param repository
	 *            save実行対象のrepository
	 * @param entity
	 *            repositoryの対となる、保存対象のentity
	 */
	@Transactional
	public <U extends EntityBase> void update(CrudRepository<U, Long> repository, U entity) {
		repository.save(entity);
	}
}
