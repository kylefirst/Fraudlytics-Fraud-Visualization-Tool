String[] fileContents = new File('points.json').readLines()

File out = new File("fixed.json")

out.write("");
out.append("{")
for(int i=0; i<fileContents.length; i++){
  String a = fileContents[i]
  int len = a.length()
  out.append("\""+i+"\": "+a+"\n")
}
out.append("}")
