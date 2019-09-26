package listener;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LunchListener extends ListenerAdapter {
	@Override
	public void onMessageReceived(MessageReceivedEvent event) {
		// TODO Auto-generated method stub
		String msg = event.getMessage().getContentRaw();
		
		if(msg.startsWith("!yy")) {
			int idx = msg.indexOf(" ");
			if(idx < 0) {
				event.getChannel().sendMessage("나도 친구없어ㅠㅠ").queue();
				return;
			}
			
			String cmd = msg.substring(idx + 1);
			idx = cmd.indexOf(" ");
			String param = "";
			if( idx > 0) {
				param = cmd.substring(idx+1);
				cmd = cmd.substring(0,idx);
			}
			switch (cmd) {
			case "echo":
				if(param == "") {
					sayMsg("echo 명령어는 메아리 할말을 입력하셔야 합니다.", event);
				}else{
					sayMsg(param, event);
				}
				break;
			case "help":
				if(param == "") {
					sayMsg("이 봇에 !yy를 치면 호출할수있고, !yy echo를 치면 메아리가 됩니다 ㅇㅇ", event);
				}
				break;
			case "자발라":
				if(param == "자발라") {
					sayMsg("어깨도 넓고 떡대도 상남자 다움 그리고 자발라 머리카락 없다고 놀리는데 자발라는 머리카락있었으면 씹게이 같았을것 ㅇㅇ", event);
			}
			}}
	}
	private void sayMsg(String msg,MessageReceivedEvent e) {
		e.getChannel().sendMessage(msg).queue();
	}
}
