<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<button id="startButton" onclick="start()">Start</button>
		<button onclick="stop()">Stop</button>
		
		<button onclick="clearText()">Clear</button>
		
		<textarea id = "displayTextArea" readonly="readonly" rows="30"></textarea>
		
		<script>
			var eventSource = null;
			
			function start(){
				eventSource = new EventSource("http://localhost:8088/eventStream");
				eventSource.onopen = function(){
					displayTextArea.value += "Connected... "+ "\n";
				};
				
				eventSource.onmessage = function(message)
				{
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