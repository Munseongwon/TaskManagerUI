/// 해야 할 일 데이터 목록
/// dummy data 이지만, jetpack compose 사용법을 익히고자 만듦
/// 할 일 번호, 제목, 내용, 시작 시간, 종료 시간 으로 구성
package com.example.todojetpack.taskManager.data

data class Task(
    val id: Int, /// 할 일 번호
    val title: String, /// 할 일 제목
    val body: String? = null, /// 할 일 내용 -> 내용이 없을 수도 있기에 '?'[옵셔널] 처리를 해준다.
    val startTime: String, /// 할 일 시작 시간
    val endTime: String /// 할 일 종료 시간
)

/// 할 일 목록이기에 List 자료형을 반환할 수 있도록 리스트를 초기화한다.
val taskList = listOf(
    Task(
        1,
        "Study Programming",
        "Flutter Coding with vs code",
        "10:00",
        "12:00",
    ),
    Task(
        2,
        "Eating Lunch",
        "Cooking sauced noodle and eating",
        "12:30",
        "13:30",
    ),
    Task(
        3,
        "Vacuum Living Room",
        "Clean Desk and closet",
        "14:00",
        "14:30",
    ),
    Task(
        4,
        "Youtube Video recording",
        "record study with me for studying people",
        "15:00",
        "18:00",
    ),
    Task(
        5,
        "Water Plants",
        "Water indoor and outdoor plants",
        "18:00",
        "18:30",
    ),
    Task(
        6,
        "Eating Dinner",
        "Cooking hamburger and eating",
        "19:00",
        "20:00",
    ),
    Task(
        7,
        "Write the plan",
        "Let's check the planner",
        "20:00",
        "20:10",
    ),
    Task(
        8,
        "Next Live Coding",
        "Flutter Coding with vs code",
        "20:30",
        "23:00",
    ),
    Task(
        9,
        "Step by Step",
        "Write tech blog and review",
        "23:30",
        "00:00",
    ),
    Task(
        10,
        "For Next day",
        "Sleeping",
        "0:00",
        "9:00",
    ),
)