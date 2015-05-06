<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<button id="startButton" onclick="start()">开始上班</button>
		<button onclick="stop()">停止接受</button>
		
		<button onclick="clearText()">清空</button>
		
		<textarea id = "displayTextArea" readonly="readonly" rows="30"></textarea>
		
		<script>
			var eventSource = null;
			
			function start(){
				eventSource = new EventSource("http://192.168.100.135:8088/receiveCheckOut/serverSent");
				/* eventSource.onopen = function(){
					displayTextArea.value += "Connected... "+ "\n";
				}; */
				
				eventSource.onmessage = function(message)
				{
					//alert(message);
					displayTextArea.value += message.data + '\n\n';
				};
				
				startButton.disabled = true;
			}
			function stop(){
				eventSource.close();
				startButton.disabled = false;
			}
			function clearText(){
				displayTextArea.value = "";
			}
		
		</script>
			
	</body>
</html>