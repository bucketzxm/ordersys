$(function(){
	$("#mainContent tr:nth-child(1)").click(
			function()
			{
				$("#mainContent tr").removeClass( "trFocus" );
				$(this).addClass( "trFocus" );
				$(this).find( "td:nth-child(1) img" ).attr( "src", "icon/现金-active.png");
				$(this).find( "td:nth-child(3) img" ).attr( "src", "icon/arrowRight.png");
				//setTimeout延时500ms跳转,现金（人工）支付
				setTimeout( "humanPay()" , 500 );
			}
	);
	
	$("#mainContent tr:nth-child(2)").click(
			function()
			{
				$("#mainContent tr").removeClass( "trFocus" );
				$(this).addClass( "trFocus" );
				$(this).find( "td:nth-child(1) img" ).attr( "src", "icon/支付宝-active.png");
				$(this).find( "td:nth-child(3) img" ).attr( "src", "icon/arrowRight.png");
				//setTimeout延时500ms跳转,支付宝支付
				setTimeout( "location='/alipayapi'", 500 );
			}
	);
});

function humanPay()
{

	location.href = "humanPayConfirm";

}