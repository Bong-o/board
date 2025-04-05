package kr.co.green.handler;

import java.util.HashMap;

import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class TransactionHandler {
	private final PlatformTransactionManager transactionManager;
	
	public TransactionHandler(PlatformTransactionManager transactionMananger) {
		this.transactionManager = transactionMananger;
	}
	
	public HashMap<String, Object> getStatus() {
		DefaultTransactionDefinition transactionDeifinition = new DefaultTransactionDefinition();
		
		transactionDeifinition.setIsolationLevel(transactionDeifinition.ISOLATION_DEFAULT);
		
		transactionDeifinition.setPropagationBehavior(transactionDeifinition.PROPAGATION_REQUIRED);
		
		TransactionStatus status = transactionManager.getTransaction(transactionDeifinition);
		
		HashMap<String, Object> result = new HashMap<>();
		result.put("status", status); // 트랜잭션 상태
		result.put("transactionManger", transactionManager); // 트랙잭션 인터페이스 (커밋 롤백)
		return result;
	}
}
