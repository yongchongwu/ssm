package com.ssm.web.rest;

import com.ssm.config.ApplicationProperties;
import com.ssm.config.AsyncProperties;
import com.ssm.dto.UserDTO;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoResource {

  private final Logger log = LoggerFactory.getLogger(DemoResource.class);

  @Autowired
  private ApplicationProperties applicationProperties;
  @Autowired
  private AsyncProperties asyncProperties;

  @ApiOperation(value = "测试1", notes = "测试1")
  @GetMapping("/demos/test1")
  public ResponseEntity<String> test1(@RequestParam(value = "name") String name) {
    log.debug("REST request to test demos");
    return ResponseEntity.ok().body(name);
  }

  @PostMapping("/demos/test2")
  public ResponseEntity<UserDTO> test2(@Valid @RequestBody UserDTO userDTO) {
    log.debug("REST request to test demos");
    return ResponseEntity.ok().body(userDTO);
  }

  @GetMapping("/demos/test3")
  public ResponseEntity<String> test3() {
    log.debug("REST request to test demos");
    return ResponseEntity.ok().body(applicationProperties.getName());
  }
  @GetMapping("/demos/test4")
  public ResponseEntity<Integer> test4() {
    log.debug("REST request to test demos");
    return ResponseEntity.ok().body(asyncProperties.getMaxPoolSize());
  }

}
