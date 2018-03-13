BEGIN{
res=0;
}

{
if($1=="r" && $4=="3" && $5=="tcp")
	{
	res++;
	}
}

END{
printf "Number of Packets received: %d",res;
}
