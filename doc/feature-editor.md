# For developers

Developers uses an IDE to code such as Eclipse or Intellij. Both provides plugins for cucumber/gherkin.

# For features writers (Monique, Amos...)

We need a simpler, generic editor with support for cucumber. This editor should have:

1. syntax highlighting for gherkin
2. auto-completion on feature steps

[Brackets.io](http://brackets.io/) and [Visual-studio-code](https://code.visualstudio.com/?utm_expid=101350005-28.R1T8FshdTBWEfZjY0s7XKQ.0&utm_referrer=https%3A%2F%2Fwww.google.ch%2F)
actually supports syntax highlighting but unfortunately not auto-completion :(

# Installation of ```Atom```

[Atom](https://atom.io/) is a text editor developed by github comes with both needed capabilities :)

1. First go to web site https://atom.io/ and download the last release.
2. Launch Atom
3. Click on 'Atom/Preferences'
4. Select tab 'Install' and search ```cucumber``` packages
5. Install packages ```cucumber``` and ```cucumber-autocomplete```
6. Select tab 'Package' and click on ```cucumber-autocomplete``` settings, fill ```Path``` to '/..'

# Fetch git repository ```nextprot-user-stories``` 

Open a terminal and execute the following commands:

```
$ git clone https://github.com/calipho-sib/nextprot-user-stories.git
$ cd ~/nextprot-user-stories/
$ bash script/update.sh
```

Come back to your Atom editor and open your directory `~/nextprot-user-stories/src/test/resources/features`

Note: Each time you want to edit, you need to execute:

```
$ cd ~/nextprot-user-stories/
$ bash script/update.sh
```

