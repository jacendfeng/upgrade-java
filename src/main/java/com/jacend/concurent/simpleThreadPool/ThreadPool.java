package com.jacend.concurent.simpleThreadPool;

public interface ThreadPool<Job extends Runnable> {

    // 执行一个 job, 这个 job 需要实现 Runnable
    void execute(Job job);

    // 关闭线程池
    void shutdown();

    // 增加工作组线程
    void addWorkers(int num);

    // 减少工作组线程
    void removeWorker(int num);

    // 得到正在执行的任务数量
    int getJobSize();
}
