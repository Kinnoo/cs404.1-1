#!/usr/bin/env bash

# This script bootstraps student environments with a private fork of the public assignment
# repository. You should not run this script from a clone of the repository. Rather, run this script
# directly using the instructions in the readme.md file.

function log_error() {
    echo "error: $1"
    exit
}

function ensure_exists() {
    program=$1
    command -v "$program" > /dev/null 2>&1 || log_error "$program not available on path"
}

function usage() {
    echo "usage: $0 username

$0 bootstraps student environments with a private fork of the public assignment repository.

Note: work in the assignment repository should only be done on unix-like environments. If you are
running Mac OS or Linux, you already have a unix-like environment. If you are running Windows,
please install the Windows Subsystem for Linux and run this script under that environment.

    Positional arguments:
        username            Your GitHub username

    Example:
        $ bash $0 fsareshwala
    "
}

function main() {
    ensure_exists git

    if [[ $# -ne 1 ]]; then
        usage
        exit
    fi

    ostype="$(uname -s)"
    case "${ostype}" in
        CYGWIN* | MINGW*)
            echo "Error: work in the assignment repository can only be done in unix environments."
            echo "Error: it appears you are running $ostype on Windows."
            echo "Error: install the Windows Subsystem for Linux and re-run this script within it."
            exit
            ;;
    esac

    git config --global core.whitespace fix,-indent-with-non-tab,trailing-space,cr-at-eol
    git config --global core.autocrlf input

    username=$1
    repo=cs404.1

    test -d $repo && rm -rf $repo

    git clone git@github.com:fsareshwala/$repo.git
    cd $repo || log_error "directory $repo does not exist"

    git remote remove origin
    git remote add -f origin git@github.com:$username/$repo.git
    git remote add -f upstream git@github.com:fsareshwala/$repo.git
    git push -uf origin master
}

main "$@"
