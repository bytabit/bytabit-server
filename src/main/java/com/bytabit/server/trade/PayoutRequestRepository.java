package com.bytabit.server.trade;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PayoutRequestRepository extends CrudRepository<PayoutRequest, String> {
}
