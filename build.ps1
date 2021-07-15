Set-Content -Encoding "utf8NoBOM" .\sources.txt "-d .\build\"
get-childitem . -include *.java -recurse -name | Add-Content -encoding "utf8NoBOM" sources.txt
javac "@sources.txt"