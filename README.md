# Gossiperl Clojure example

Very simple example of using gossiperl client with Clojure.

## Known issues

If the application is running under Oracle Java and the following error appears:

    Java Security: Illegal key size

It can be resolved by following these steps: http://stackoverflow.com/a/6481658/56250.

## Getting the JVM library:

    VERSION=0.1
    git clone https://github.com/gossiperl/gossiperl-client-jvm.git
    cd gossiperl-client-jvm/
    git tags -l
    git checkout v$VERSION
    mvn clean install -Dmaven.test.skip=true
    mvn install:install-file -Dfile=target/gossiperl-client-$VERSION-SNAPSHOT-jar-with-dependencies.jar -DpomFile=pom.xml

## Running the example

    lein deps
    lein run

# License

The MIT License (MIT)

Copyright (c) 2014 Radoslaw Gruchalski <radek@gruchalski.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.