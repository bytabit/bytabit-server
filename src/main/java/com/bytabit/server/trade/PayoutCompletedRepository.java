package com.bytabit.server.trade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PayoutCompletedRepository extends CrudRepository<PayoutCompleted, String> {
}
