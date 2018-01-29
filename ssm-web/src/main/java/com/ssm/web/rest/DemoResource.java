package com.ssm.web.rest;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.config.ApplicationProperties;
import com.ssm.config.AsyncProperties;
import com.ssm.dto.UserDTO;
import com.ssm.entity.User;
import com.ssm.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @Autowired
  private UserService userService;

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

  @GetMapping("/demos/test5")
  public ResponseEntity<List> test5() {
    log.debug("REST request to test demos");
    List<User> list = userService.getAll();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping("/demos/test5/{id}")
  public ResponseEntity<User> test5(@PathVariable Integer id) {
    log.debug("REST request to test demos");
    User user = userService.getOne(id);
    return ResponseEntity.ok().body(user);
  }

  @GetMapping("/demos/test6")
  public ResponseEntity<PageInfo> test6(@RequestParam(value = "start") Integer start,
      @RequestParam(value = "limit") Integer limit) {
    log.debug("REST request to test demos");
    PageHelper.startPage(start, limit);
    List<User> userList = userService.getAll();
    PageInfo pageInfo = new PageInfo(userList);
    return ResponseEntity.ok().body(pageInfo);
  }

  @GetMapping("/demos/test7")
  public ResponseEntity<PageInfo> test7(@RequestParam(value = "start") Integer start,
      @RequestParam(value = "limit") Integer limit,@RequestParam(value = "orderBy") String orderBy) {
    log.debug("REST request to test demos");
    PageHelper.startPage(start,limit,orderBy);
    List<User> userList = userService.getAll();
    PageInfo pageInfo = new PageInfo(userList);
    return ResponseEntity.ok().body(pageInfo);
  }

  @GetMapping("/demos/test8/{id}")
  public ResponseEntity<User> test8(@PathVariable Integer id) {
    log.debug("REST request to test demos");
    User user = userService.selectUser(id);
    return ResponseEntity.ok().body(user);
  }

  @GetMapping("/demos/test9")
  public ResponseEntity<PageInfo> test9(@RequestParam(value = "start") Integer start,
      @RequestParam(value = "limit") Integer limit,@RequestParam(value = "orderBy") String orderBy) {
    log.debug("REST request to test demos");
    PageHelper.startPage(start,limit,orderBy);
    List<User> userList = userService.selectAllUser();
    PageInfo pageInfo = new PageInfo(userList);
    return ResponseEntity.ok().body(pageInfo);
  }

}
