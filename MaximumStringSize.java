public int Solution(String A, String B ){
  HashMap<Character, Integer> Bmap= new HashMap<Character, Integer>();
  for (int i= 0; i<B.length(); i++){
      Char bc = B.charAt(i);
      if (Bmap.containsKey(bc)){
          Bmap.put(bc, Bmap.get(bc)+1);
      }else{
      Bmap.put(bc, 1);
      }
  }
  int Uniquelen = Bmap.size();
  int s = 0;
  int e = 0;
  int counter = 0;
  int ans=Integer.MAX_VALUE;
  HashMap<Character, Integer> Amap= new HashMap<Character, Integer>();
	  while (e <= A.length() && s<= A.length()){
		char ac = A.charAt(e);
		if (Amap.containsKey(ac)){
			Amap.put(bc, Amap.get(ac)+1);
		}else{
			Amap.put(ac, 1);
		}
		if(Bmap.get(ac) == Amap.get(ac)){
			counter++;
		}
		if(counter==Uniquelen){
			ans= Math.min(ans, e-s+1);
		}
		while(counter == Uniquelen){
			Char as = A.charAt(s);
			Amap.put(as, Amap.get(as)-1);
			if(Amap.get(as)< Bmap.get(as)){
				counter--;
			}
			s++;
		}
		e++;
	  }
}
