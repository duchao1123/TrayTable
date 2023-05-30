package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Counter;
import org.apache.ibatis.annotations.Param;

import java.util.Optional;
import java.util.List;

public interface CounterService {

  Optional<Counter> getCounter(Integer id);

  void upsertCount(Counter counter);

  void clearCount(Integer id);
}
