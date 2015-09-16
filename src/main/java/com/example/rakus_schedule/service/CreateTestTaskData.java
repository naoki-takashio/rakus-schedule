package com.example.rakus_schedule.service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rakus_schedule.domain.Task;

/**
 * テストデータ作成用クラス.
 * もっといいやり方があるんだろうけどとりあえず動作確認のために作成.
 * @author takashionaoki
 *
 */
@Service
public class CreateTestTaskData {

	public List<Object> createTestTaskList() {
	
	Date date = new Date(System.currentTimeMillis());
	Timestamp time = new Timestamp(System.currentTimeMillis());
	List<String> testList = new ArrayList<String>();
	
	Task testTask1 = new Task(1,"test1",0,"testtest",1,"高",0,"testtag",time,1,2,1,time,date,date,date,date,date,false,false,testList);
	Task testTask2 = new Task(2,"test2",1,"testtest",1,"高",0,"testtag",time,1,2,1,time,date,date,date,date,date,false,false,testList);
	Task testTask3 = new Task(3,"test3",2,"testtest",1,"高",0,"testtag",time,1,2,1,time,date,date,date,date,date,false,false,testList);
	Task testTask4 = new Task(4,"test4",3,"testtest",1,"高",0,"testtag",time,1,2,1,time,date,date,date,date,date,false,false,testList);
	Task testTask5 = new Task(5,"test5",0,"testtest",2,"高",0,"testtag",time,1,2,1,time,date,date,date,date,date,false,false,testList);
	
	List<Object> allTaskList = new ArrayList<Object>();
	List<Task> standByTaskList = new ArrayList<Task>();
	List<Task> workingTaskList = new ArrayList<Task>();
	List<Task> inReviewTaskList = new ArrayList<Task>();
	List<Task> doneTaskList = new ArrayList<Task>();
	
	standByTaskList.add(testTask1);
	standByTaskList.add(testTask5);
	workingTaskList.add(testTask2);
	inReviewTaskList.add(testTask3);
	doneTaskList.add(testTask4);
	
	allTaskList.add(standByTaskList);
	allTaskList.add(workingTaskList);
	allTaskList.add(inReviewTaskList);
	allTaskList.add(doneTaskList);
	
	return allTaskList;
	}

}
