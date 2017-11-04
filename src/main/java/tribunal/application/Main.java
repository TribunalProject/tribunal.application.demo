package tribunal.application;

import tribunal.core.LawService;
import tribunal.core.VerdictService;
import tribunal.tool.Logger;
import tribunal.tool.StringColor;

public class Main {

    static Logger log = new Logger("tribunal.application.Main");

    public static void main(String[] args){
        log.debugln("Laws registring...", StringColor.GREEN);
        LawService.getInstance().registryLaws();
        log.debugln("Plugin and Verdicts initialize...", StringColor.GREEN);
        VerdictService.getInstance().init();
        log.debugln("Plugin start...", StringColor.GREEN);
        VerdictService.getInstance().start();

        String demoText1 = "テスト";
        log.debugln("Law1: テスト, Target: " + demoText1, StringColor.GREEN);
        VerdictService.getInstance().call(
            LawService.getInstance().containsLaw(demoText1)
        );

        String demoText2 = "明日から頑張る";
        log.debugln("Law2: (.*)から(.*), Target: " + demoText2, StringColor.GREEN);
        VerdictService.getInstance().call(
                LawService.getInstance().containsLaw(demoText2)
        );

        String demoText3 = "犬";
        log.debugln("Law3: 猫, Target: " + demoText3, StringColor.GREEN);
        VerdictService.getInstance().call(
                LawService.getInstance().containsLaw(demoText3)
        );

        String demoText4 = "にゃー";
        String demoExecutor = "c-ardinal";
        log.debugln("Law4: にゃー, Target: " + demoText4 + ", Executable: HogeHoge, Executor: c-ardinal", StringColor.GREEN);
        VerdictService.getInstance().call(
                LawService.getInstance().containsLaw(demoText4, demoExecutor)
        );
    }
}
