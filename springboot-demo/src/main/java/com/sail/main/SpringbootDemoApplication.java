package com.sail.main;

import com.sail.condition.ConditionConfig;
import com.sail.condition.ListService;
import com.sail.config.*;
import com.sail.domain.DemoBean;
import com.sail.domain.Root;
import com.sail.event.DemoPublisher;
import com.sail.service.DemoService;
import com.sail.service.async.AsyncTaskService;
import com.sail.service.annotation.DemoAnnotationService;
import com.sail.service.annotation.DemoMethodService;
import com.sail.service.aware.AwareService;
import com.sail.service.perpost.BeanWayService;
import com.sail.service.perpost.JSR250WayService;
import com.sail.service.perpost.PrePostConfig;
import com.sail.service.type1.UseFunctionService;
import com.sail.service.type2.UseFunctionService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringbootDemoApplication {

    @RequestMapping("/index")
    String index(){
        return "success";
    }

    @RequestMapping("/page")
    String page(){
        return "page";
    }

    @Autowired
    private static Root root;


    public static void main(String[] args) {//-Ddebug
//        main0();
//        main1();
//        main2();
//        main3();
//        main4();
//        main5();
//        mainBean();
//        mainProfile();
//        mainProfileMine();
//        mainEvent();
//        mainAware();
//        mainTaskTest();
//        mainScheduler();//TODO 有报错
//        mainCondition();
        mainWiselyAnnotation();
    }

    public static void mainWiselyAnnotation(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        DemoService demoService = context.getBean(DemoService.class);
        demoService.outputResult();
        context.close();
    }

    public static void mainCondition(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService listService = context.getBean(ListService.class);
        System.out.println(context.getEnvironment().getProperty("os.name")+
                "系统下的列表命令为：" + listService.showListCmd());
    }

    public static void mainScheduler(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskSchedulerConfig.class);
        //TODO 不需要调用start方法就行了啊。。。。。。。
    }

    public static void mainTaskTest() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigForAnnotation.class);
        AsyncTaskService asyncTaskService = context.getBean(AsyncTaskService.class);
        for (int i=0;i<10;i++){
            asyncTaskService.executeAsyncTask(i);
            asyncTaskService.executeAsyncTaskPlus(i);
        }
        context.close();

    }

    public static void mainAware(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigForAnnotation.class);
        AwareService awareService = context.getBean(AwareService.class);
        awareService.outputResult();
        context.close();
    }

    public static void mainEvent(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigForAnnotation.class);
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello application event");
        context.close();
    }
    /**验证读不到spring.profiles.active,
     * 怎样才能读到application.xml
     * */
    public static void mainProfileMine(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        context.start();
    }
//    Exception in thread "main" java.lang.IllegalStateException: LifecycleProcessor not initialized - call 'refresh' before invoking lifecycle methods via the context: org.springframework.context.annotation.AnnotationConfigApplicationContext@34340fab: startup date [Thu Jan 01 08:00:00 CST 1970]; root of context hierarchy
//    at org.springframework.context.support.AbstractApplicationContext.getLifecycleProcessor(AbstractApplicationContext.java:434)
//    at org.springframework.context.support.AbstractApplicationContext.start(AbstractApplicationContext.java:1319)
//    at com.sail.main.SpringbootDemoApplication.mainProfileMine(SpringbootDemoApplication.java:144)
//    at com.sail.main.SpringbootDemoApplication.main(SpringbootDemoApplication.java:51)
    @Value("${spring.profiles.active}")
    static  String profile;
    public static void mainProfile(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext();
        System.out.println("${spring.profiles.active}*********"+profile);
        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        for (String string :activeProfiles
                ) {
            System.out.println("*********"+string);
        }

        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileConfig.class);
        context.refresh();

        DemoBean demoBean = context.getBean(DemoBean.class);
        System.out.println(demoBean.getContent());
        String[] activeProfiles2 = context.getEnvironment().getActiveProfiles();
        for (String string :activeProfiles2
                ) {
            System.out.println("*********"+string);
        }
        context.close();
    }
    public static void mainBean(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(PrePostConfig.class);
        BeanWayService beanWayService = context.getBean(BeanWayService.class);
        JSR250WayService jsr250WayService = context.getBean(JSR250WayService.class);
        context.close();
    }
    public static void main5(){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ELConfig.class);
        System.out.println("***");
        System.out.println(root);
        ELConfig elConfig = context.getBean(ELConfig.class);
        elConfig.outputResource();
    }
    public static void main4(){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ConfigForAnnotation.class);
        Root root = context.getBean(Root.class);
        System.out.println(root.getAge());
        System.out.println(root.getName());
        Environment environment = root.getEnvironment();
        System.out.println("***********"+environment);
        System.out.println(environment.getProperty("root.sex"));
//        System.out.println(root.getSex());
    }
    public static void main3(){
        AnnotationConfigApplicationContext context=
                new AnnotationConfigApplicationContext(ConfigForAnnotation.class);
        DemoAnnotationService annotationService = context.getBean(DemoAnnotationService.class);
        DemoMethodService methodService = context.getBean(DemoMethodService.class);
        annotationService.add();
        methodService.add();
        context.close();
    }
    public static void main2(){
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(ConfigForFunctionService2.class);
        UseFunctionService2 service2 = context.getBean(UseFunctionService2.class);

        System.out.println(service2.sayHello("function2"));
        context.close();
    }
    public static void main1(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigForFunctionService.class);
        UseFunctionService service = context.getBean(UseFunctionService.class);
        System.out.println(service.sayHello("SpringBoot"));
        context.close();
    }
    public static void main0(){
        SpringApplication.run(SpringbootDemoApplication.class, new String[]{});
    }

}



//region   balabala

//something

//endregion