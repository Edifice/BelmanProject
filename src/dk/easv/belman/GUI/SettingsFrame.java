  


<!DOCTYPE html>
<html>
  <head prefix="og: http://ogp.me/ns# fb: http://ogp.me/ns/fb# githubog: http://ogp.me/ns/fb/githubog#">
    <meta charset='utf-8'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>BelmanProject/src/dk/easv/belman/GUI/SettingsFrame.java at 07a4295057b369db23459139b9ebbf55e177f385 · anthonymonori/BelmanProject</title>
    <link rel="search" type="application/opensearchdescription+xml" href="/opensearch.xml" title="GitHub" />
    <link rel="fluid-icon" href="https://github.com/fluidicon.png" title="GitHub" />
    <link rel="apple-touch-icon" sizes="57x57" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="114x114" href="/apple-touch-icon-114.png" />
    <link rel="apple-touch-icon" sizes="72x72" href="/apple-touch-icon-144.png" />
    <link rel="apple-touch-icon" sizes="144x144" href="/apple-touch-icon-144.png" />
    <link rel="logo" type="image/svg" href="http://github-media-downloads.s3.amazonaws.com/github-logo.svg" />
    <link rel="xhr-socket" href="/_sockets" />
    


    <meta name="msapplication-TileImage" content="/windows-tile.png" />
    <meta name="msapplication-TileColor" content="#ffffff" />
    <meta name="selected-link" value="repo_source" data-pjax-transient />
    <meta content="collector.githubapp.com" name="octolytics-host" /><meta content="github" name="octolytics-app-id" /><meta content="935897" name="octolytics-actor-id" /><meta content="anthonymonori" name="octolytics-actor-login" /><meta content="68aa86c66362a8eee33aa91fc892654ea95b676060ea30191db9e24aae3aab33" name="octolytics-actor-hash" />

    
    
    <link rel="icon" type="image/x-icon" href="/favicon.ico" />

    <meta content="authenticity_token" name="csrf-param" />
<meta content="0xGzYfu+dkClUjaEVbV52GLejPRYDCSeJT/vMZFF7So=" name="csrf-token" />

    <link href="https://a248.e.akamai.net/assets.github.com/assets/github-2e53882cf8306e277ea0d07dbb6117f926c38f6c.css" media="all" rel="stylesheet" type="text/css" />
    <link href="https://a248.e.akamai.net/assets.github.com/assets/github2-8ea4ea72d7b478cc437d5b2e6841998ad79f1396.css" media="all" rel="stylesheet" type="text/css" />
    


      <script src="https://a248.e.akamai.net/assets.github.com/assets/frameworks-5c60c478b1e0f90d149f11ed15aa52edd2996882.js" type="text/javascript"></script>
      <script src="https://a248.e.akamai.net/assets.github.com/assets/github-30e75eead7a0b9c0c4bf82707cbb7e5ab8958275.js" type="text/javascript"></script>
      
      <meta http-equiv="x-pjax-version" content="826cbddbd868f774d2e661bb4f461de5">

        <link data-pjax-transient rel='permalink' href='/anthonymonori/BelmanProject/blob/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI/SettingsFrame.java'>
    <meta property="og:title" content="BelmanProject"/>
    <meta property="og:type" content="githubog:gitrepository"/>
    <meta property="og:url" content="https://github.com/anthonymonori/BelmanProject"/>
    <meta property="og:image" content="https://secure.gravatar.com/avatar/0bb6706211992795e4bf449ce6713072?s=420&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png"/>
    <meta property="og:site_name" content="GitHub"/>
    <meta property="og:description" content="BelmanProject - More info: https://gist.github.com/anthonymonori/affff2fe8448f401ba5e"/>
    <meta property="twitter:card" content="summary"/>
    <meta property="twitter:site" content="@GitHub">
    <meta property="twitter:title" content="anthonymonori/BelmanProject"/>

    <meta name="description" content="BelmanProject - More info: https://gist.github.com/anthonymonori/affff2fe8448f401ba5e" />


    <meta content="935897" name="octolytics-dimension-user_id" /><meta content="anthonymonori" name="octolytics-dimension-user_login" /><meta content="9410376" name="octolytics-dimension-repository_id" /><meta content="anthonymonori/BelmanProject" name="octolytics-dimension-repository_nwo" /><meta content="false" name="octolytics-dimension-repository_public" /><meta content="false" name="octolytics-dimension-repository_is_fork" /><meta content="9410376" name="octolytics-dimension-repository_network_root_id" /><meta content="anthonymonori/BelmanProject" name="octolytics-dimension-repository_network_root_nwo" />
  <link href="https://github.com/anthonymonori/BelmanProject/commits/07a4295057b369db23459139b9ebbf55e177f385.atom?login=anthonymonori&token=9c5e65143c60c9875003e0e4afff3210" rel="alternate" title="Recent Commits to BelmanProject:07a4295057b369db23459139b9ebbf55e177f385" type="application/atom+xml" />

  </head>


  <body class="logged_in page-blob windows vis-private env-production  ">
    <div id="wrapper">

      
      
      

      <div class="header header-logged-in true">
  <div class="container clearfix">

    <a class="header-logo-invertocat" href="https://github.com/">
  <span class="mega-octicon octicon-mark-github"></span>
</a>

    <div class="divider-vertical"></div>

      <a href="/notifications" class="notification-indicator tooltipped downwards" title="You have no unread notifications">
    <span class="mail-status all-read"></span>
  </a>
  <div class="divider-vertical"></div>


      <div class="command-bar js-command-bar  in-repository">
          <form accept-charset="UTF-8" action="/search" class="command-bar-form" id="top_search_form" method="get">
  <a href="/search/advanced" class="advanced-search-icon tooltipped downwards command-bar-search" id="advanced_search" title="Advanced search"><span class="octicon octicon-gear "></span></a>

  <input type="text" data-hotkey="/ s" name="q" id="js-command-bar-field" placeholder="Search or type a command" tabindex="1" autocapitalize="off"
    data-username="anthonymonori"
      data-repo="anthonymonori/BelmanProject"
      data-branch=""
      data-sha="2bfc95e97b9e5485b565f08c995b991235a2eb8b"
  >

    <input type="hidden" name="nwo" value="anthonymonori/BelmanProject" />

    <div class="select-menu js-menu-container js-select-menu search-context-select-menu">
      <span class="minibutton select-menu-button js-menu-target">
        <span class="js-select-button">This repository</span>
      </span>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container">
        <div class="select-menu-modal">

          <div class="select-menu-item js-navigation-item selected">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" class="js-search-this-repository" name="search_target" value="repository" checked="checked" />
            <div class="select-menu-item-text js-select-button-text">This repository</div>
          </div> <!-- /.select-menu-item -->

          <div class="select-menu-item js-navigation-item">
            <span class="select-menu-item-icon octicon octicon-check"></span>
            <input type="radio" name="search_target" value="global" />
            <div class="select-menu-item-text js-select-button-text">All repositories</div>
          </div> <!-- /.select-menu-item -->

        </div>
      </div>
    </div>

  <span class="octicon help tooltipped downwards" title="Show command bar help">
    <span class="octicon octicon-question"></span>
  </span>


  <input type="hidden" name="ref" value="cmdform">

  <div class="divider-vertical"></div>

</form>
        <ul class="top-nav">
            <li class="explore"><a href="/explore">Explore</a></li>
            <li><a href="https://gist.github.com">Gist</a></li>
            <li><a href="/blog">Blog</a></li>
          <li><a href="http://help.github.com">Help</a></li>
        </ul>
      </div>

    

  

    <ul id="user-links">
      <li>
        <a href="/anthonymonori" class="name">
          <img height="20" src="https://secure.gravatar.com/avatar/0bb6706211992795e4bf449ce6713072?s=140&amp;d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png" width="20" /> anthonymonori
        </a>
      </li>

        <li>
          <a href="/new" id="new_repo" class="tooltipped downwards" title="Create a new repo">
            <span class="octicon octicon-repo-create"></span>
          </a>
        </li>

        <li>
          <a href="/settings/profile" id="account_settings"
            class="tooltipped downwards"
            title="Account settings ">
            <span class="octicon octicon-tools"></span>
          </a>
        </li>
        <li>
          <a class="tooltipped downwards" href="/logout" data-method="post" id="logout" title="Sign out">
            <span class="octicon octicon-log-out"></span>
          </a>
        </li>

    </ul>


<div class="js-new-dropdown-contents hidden">
  <ul class="dropdown-menu">
    <li>
      <a href="/new"><span class="octicon octicon-repo-create"></span> New repository</a>
    </li>
    <li>
        <a href="/anthonymonori/BelmanProject/issues/new"><span class="octicon octicon-issue-opened"></span> New issue</a>
    </li>
    <li>
    </li>
    <li>
      <a href="/organizations/new"><span class="octicon octicon-list-unordered"></span> New organization</a>
    </li>
  </ul>
</div>


    
  </div>
</div>

      

      


            <div class="site hfeed" itemscope itemtype="http://schema.org/WebPage">
      <div class="hentry">
        
        <div class="pagehead repohead instapaper_ignore readability-menu ">
          <div class="container">
            <div class="title-actions-bar">
              

<ul class="pagehead-actions">

    <li class="nspr">
      <a href="/anthonymonori/BelmanProject/pull/new/07a4295057b369db23459139b9ebbf55e177f385" class="button minibutton btn-pull-request" icon_class="octicon-git-pull-request"><span class="octicon octicon-git-pull-request"></span>Pull Request</a>
    </li>

    <li class="subscription">
      <form accept-charset="UTF-8" action="/notifications/subscribe" data-autosubmit="true" data-remote="true" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="0xGzYfu+dkClUjaEVbV52GLejPRYDCSeJT/vMZFF7So=" /></div>  <input id="repository_id" name="repository_id" type="hidden" value="9410376" />

    <div class="select-menu js-menu-container js-select-menu">
      <span class="minibutton select-menu-button js-menu-target">
        <span class="js-select-button">
          <span class="octicon octicon-eye-unwatch"></span>
          Unwatch
        </span>
      </span>

      <div class="select-menu-modal-holder js-menu-content">
        <div class="select-menu-modal">
          <div class="select-menu-header">
            <span class="select-menu-title">Notification status</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-list js-navigation-container">

            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_included" name="do" type="radio" value="included" />
                <h4>Not watching</h4>
                <span class="description">You only receive notifications for discussions in which you participate or are @mentioned.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-watch"></span>
                  Watch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item selected">
              <span class="select-menu-item-icon octicon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input checked="checked" id="do_subscribed" name="do" type="radio" value="subscribed" />
                <h4>Watching</h4>
                <span class="description">You receive notifications for all discussions in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-eye-unwatch"></span>
                  Unwatch
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

            <div class="select-menu-item js-navigation-item ">
              <span class="select-menu-item-icon octicon octicon-check"></span>
              <div class="select-menu-item-text">
                <input id="do_ignore" name="do" type="radio" value="ignore" />
                <h4>Ignoring</h4>
                <span class="description">You do not receive any notifications for discussions in this repository.</span>
                <span class="js-select-button-text hidden-select-button-text">
                  <span class="octicon octicon-mute"></span>
                  Stop ignoring
                </span>
              </div>
            </div> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

</form>
    </li>

    <li class="js-toggler-container js-social-container starring-container ">
      <a href="/anthonymonori/BelmanProject/unstar" class="minibutton js-toggler-target star-button starred upwards" title="Unstar this repo" data-remote="true" data-method="post" rel="nofollow">
        <span class="octicon octicon-star-delete"></span>
        <span class="text">Unstar</span>
      </a>
      <a href="/anthonymonori/BelmanProject/star" class="minibutton js-toggler-target star-button unstarred upwards" title="Star this repo" data-remote="true" data-method="post" rel="nofollow">
        <span class="octicon octicon-star"></span>
        <span class="text">Star</span>
      </a>
      <a class="social-count js-social-count" href="/anthonymonori/BelmanProject/stargazers">1</a>
    </li>

        <li>
          <a href="/anthonymonori/BelmanProject/fork" class="minibutton js-toggler-target fork-button lighter upwards" title="Fork this repo" rel="nofollow" data-method="post">
            <span class="octicon octicon-git-branch-create"></span>
            <span class="text">Fork</span>
          </a>
          <a href="/anthonymonori/BelmanProject/network" class="social-count">0</a>
        </li>


</ul>

              <h1 itemscope itemtype="http://data-vocabulary.org/Breadcrumb" class="entry-title private">
                <span class="repo-label"><span>private</span></span>
                <span class="mega-octicon octicon-lock"></span>
                <span class="author vcard">
                  <a href="/anthonymonori" class="url fn" itemprop="url" rel="author">
                  <span itemprop="title">anthonymonori</span>
                  </a></span> /
                <strong><a href="/anthonymonori/BelmanProject" class="js-current-repository">BelmanProject</a></strong>
              </h1>
            </div>

            
  <ul class="tabs">
    <li class="pulse-nav"><a href="/anthonymonori/BelmanProject/pulse" class="js-selected-navigation-item " data-selected-links="pulse /anthonymonori/BelmanProject/pulse" rel="nofollow"><span class="octicon octicon-pulse"></span></a></li>
    <li><a href="/anthonymonori/BelmanProject" class="js-selected-navigation-item selected" data-selected-links="repo_source repo_downloads repo_commits repo_tags repo_branches /anthonymonori/BelmanProject">Code</a></li>
    <li><a href="/anthonymonori/BelmanProject/network" class="js-selected-navigation-item " data-selected-links="repo_network /anthonymonori/BelmanProject/network">Network</a></li>
    <li><a href="/anthonymonori/BelmanProject/pulls" class="js-selected-navigation-item " data-selected-links="repo_pulls /anthonymonori/BelmanProject/pulls">Pull Requests <span class='counter'>0</span></a></li>




    <li><a href="/anthonymonori/BelmanProject/graphs" class="js-selected-navigation-item " data-selected-links="repo_graphs repo_contributors /anthonymonori/BelmanProject/graphs">Graphs</a></li>

      <li>
        <a href="/anthonymonori/BelmanProject/settings">Settings</a>
      </li>

  </ul>
  
<div class="tabnav">

  <span class="tabnav-right">
    <ul class="tabnav-tabs">
          <li><a href="/anthonymonori/BelmanProject/tags" class="js-selected-navigation-item tabnav-tab" data-selected-links="repo_tags /anthonymonori/BelmanProject/tags">Tags <span class="counter ">3</span></a></li>
    </ul>
  </span>

  <div class="tabnav-widget scope">


    <div class="select-menu js-menu-container js-select-menu js-branch-menu">
      <a class="minibutton select-menu-button js-menu-target" data-hotkey="w" data-ref="">
        <span class="octicon octicon-tree"></span>
        <i>tree:</i>
        <span class="js-select-button">07a4295057</span>
      </a>

      <div class="select-menu-modal-holder js-menu-content js-navigation-container">

        <div class="select-menu-modal">
          <div class="select-menu-header">
            <span class="select-menu-title">Switch branches/tags</span>
            <span class="octicon octicon-remove-close js-menu-close"></span>
          </div> <!-- /.select-menu-header -->

          <div class="select-menu-filters">
            <div class="select-menu-text-filter">
              <input type="text" id="commitish-filter-field" class="js-filterable-field js-navigation-enable" placeholder="Find or create a branch…">
            </div>
            <div class="select-menu-tabs">
              <ul>
                <li class="select-menu-tab">
                  <a href="#" data-tab-filter="branches" class="js-select-menu-tab">Branches</a>
                </li>
                <li class="select-menu-tab">
                  <a href="#" data-tab-filter="tags" class="js-select-menu-tab">Tags</a>
                </li>
              </ul>
            </div><!-- /.select-menu-tabs -->
          </div><!-- /.select-menu-filters -->

          <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket css-truncate" data-tab-filter="branches">

            <div data-filterable-for="commitish-filter-field" data-filterable-type="substring">

                <div class="select-menu-item js-navigation-item ">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/anthonymonori/BelmanProject/blob/dev/src/dk/easv/belman/GUI/SettingsFrame.java" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="dev" rel="nofollow" title="dev">dev</a>
                </div> <!-- /.select-menu-item -->
                <div class="select-menu-item js-navigation-item ">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/anthonymonori/BelmanProject/blob/master/src/dk/easv/belman/GUI/SettingsFrame.java" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="master" rel="nofollow" title="master">master</a>
                </div> <!-- /.select-menu-item -->
            </div>

              <form accept-charset="UTF-8" action="/anthonymonori/BelmanProject/branches" class="js-create-branch select-menu-item select-menu-new-item-form js-navigation-item js-new-item-form" method="post"><div style="margin:0;padding:0;display:inline"><input name="authenticity_token" type="hidden" value="0xGzYfu+dkClUjaEVbV52GLejPRYDCSeJT/vMZFF7So=" /></div>

                <span class="octicon octicon-git-branch-create select-menu-item-icon"></span>
                <div class="select-menu-item-text">
                  <h4>Create branch: <span class="js-new-item-name"></span></h4>
                  <span class="description">from ‘07a4295057b369db23459139b9ebbf55e177f385’</span>
                </div>
                <input type="hidden" name="name" id="name" class="js-new-item-value">
                <input type="hidden" name="branch" id="branch" value="07a4295057b369db23459139b9ebbf55e177f385" />
                <input type="hidden" name="path" id="branch" value="src/dk/easv/belman/GUI/SettingsFrame.java" />
              </form> <!-- /.select-menu-item -->

          </div> <!-- /.select-menu-list -->


          <div class="select-menu-list select-menu-tab-bucket js-select-menu-tab-bucket css-truncate" data-tab-filter="tags">
            <div data-filterable-for="commitish-filter-field" data-filterable-type="substring">

                <div class="select-menu-item js-navigation-item ">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/anthonymonori/BelmanProject/blob/Sprint2/src/dk/easv/belman/GUI/SettingsFrame.java" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="Sprint2" rel="nofollow" title="Sprint2">Sprint2</a>
                </div> <!-- /.select-menu-item -->
                <div class="select-menu-item js-navigation-item ">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/anthonymonori/BelmanProject/blob/Sprint1/src/dk/easv/belman/GUI/SettingsFrame.java" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="Sprint1" rel="nofollow" title="Sprint1">Sprint1</a>
                </div> <!-- /.select-menu-item -->
                <div class="select-menu-item js-navigation-item ">
                  <span class="select-menu-item-icon octicon octicon-check"></span>
                  <a href="/anthonymonori/BelmanProject/blob/Final/src/dk/easv/belman/GUI/SettingsFrame.java" class="js-navigation-open select-menu-item-text js-select-button-text css-truncate-target" data-name="Final" rel="nofollow" title="Final">Final</a>
                </div> <!-- /.select-menu-item -->
            </div>

            <div class="select-menu-no-results">Nothing to show</div>

          </div> <!-- /.select-menu-list -->

        </div> <!-- /.select-menu-modal -->
      </div> <!-- /.select-menu-modal-holder -->
    </div> <!-- /.select-menu -->

  </div> <!-- /.scope -->

  <ul class="tabnav-tabs">
    <li><a href="/anthonymonori/BelmanProject" class="selected js-selected-navigation-item tabnav-tab" data-selected-links="repo_source /anthonymonori/BelmanProject">Files</a></li>
    <li><a href="/anthonymonori/BelmanProject/commits/" class="js-selected-navigation-item tabnav-tab" data-selected-links="repo_commits /anthonymonori/BelmanProject/commits/">Commits</a></li>
    <li><a href="/anthonymonori/BelmanProject/branches" class="js-selected-navigation-item tabnav-tab" data-selected-links="repo_branches /anthonymonori/BelmanProject/branches" rel="nofollow">Branches <span class="counter ">2</span></a></li>
  </ul>

</div>

  
  
  


            
          </div>
        </div><!-- /.repohead -->

        <div id="js-repo-pjax-container" class="container context-loader-container" data-pjax-container>
          


<!-- blob contrib key: blob_contributors:v21:2d2baa2933d1eb96a8bc2c558711807e -->
<!-- blob contrib frag key: views10/v8/blob_contributors:v21:2d2baa2933d1eb96a8bc2c558711807e -->


<div id="slider">
    <div class="frame-meta">

      <p title="This is a placeholder element" class="js-history-link-replace hidden"></p>

        <div class="breadcrumb">
          <span class='bold'><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/anthonymonori/BelmanProject/tree/07a4295057b369db23459139b9ebbf55e177f385" class="js-slide-to" data-branch="07a4295057b369db23459139b9ebbf55e177f385" data-direction="back" itemscope="url" rel="nofollow"><span itemprop="title">BelmanProject</span></a></span></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/anthonymonori/BelmanProject/tree/07a4295057b369db23459139b9ebbf55e177f385/src" class="js-slide-to" data-branch="07a4295057b369db23459139b9ebbf55e177f385" data-direction="back" itemscope="url" rel="nofollow"><span itemprop="title">src</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/anthonymonori/BelmanProject/tree/07a4295057b369db23459139b9ebbf55e177f385/src/dk" class="js-slide-to" data-branch="07a4295057b369db23459139b9ebbf55e177f385" data-direction="back" itemscope="url" rel="nofollow"><span itemprop="title">dk</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/anthonymonori/BelmanProject/tree/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv" class="js-slide-to" data-branch="07a4295057b369db23459139b9ebbf55e177f385" data-direction="back" itemscope="url" rel="nofollow"><span itemprop="title">easv</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/anthonymonori/BelmanProject/tree/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman" class="js-slide-to" data-branch="07a4295057b369db23459139b9ebbf55e177f385" data-direction="back" itemscope="url" rel="nofollow"><span itemprop="title">belman</span></a></span><span class="separator"> / </span><span itemscope="" itemtype="http://data-vocabulary.org/Breadcrumb"><a href="/anthonymonori/BelmanProject/tree/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI" class="js-slide-to" data-branch="07a4295057b369db23459139b9ebbf55e177f385" data-direction="back" itemscope="url" rel="nofollow"><span itemprop="title">GUI</span></a></span><span class="separator"> / </span><strong class="final-path">SettingsFrame.java</strong> <span class="js-zeroclipboard zeroclipboard-button" data-clipboard-text="src/dk/easv/belman/GUI/SettingsFrame.java" data-copied-hint="copied!" title="copy to clipboard"><span class="octicon octicon-clippy"></span></span>
        </div>

      <a href="/anthonymonori/BelmanProject/find/07a4295057b369db23459139b9ebbf55e177f385" class="js-slide-to" data-hotkey="t" style="display:none">Show File Finder</a>


        <div class="commit commit-loader file-history-tease js-deferred-content" data-url="/anthonymonori/BelmanProject/contributors/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI/SettingsFrame.java">
          Fetching contributors…

          <div class="participation">
            <p class="loader-loading"><img alt="Octocat-spinner-32-eaf2f5" height="16" src="https://a248.e.akamai.net/assets.github.com/images/spinners/octocat-spinner-32-EAF2F5.gif?1360648847" width="16" /></p>
            <p class="loader-error">Cannot retrieve contributors at this time</p>
          </div>
        </div>

    </div><!-- ./.frame-meta -->

    <div class="frames">
      <div class="frame" data-permalink-url="/anthonymonori/BelmanProject/blob/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI/SettingsFrame.java" data-title="BelmanProject/src/dk/easv/belman/GUI/SettingsFrame.java at 07a4295057b369db23459139b9ebbf55e177f385 · anthonymonori/BelmanProject · GitHub" data-type="blob">

        <div id="files" class="bubble">
          <div class="file">
            <div class="meta">
              <div class="info">
                <span class="icon"><b class="octicon octicon-file-text"></b></span>
                <span class="mode" title="File Mode">file</span>
                  <span>198 lines (180 sloc)</span>
                <span>10.743 kb</span>
              </div>
              <div class="actions">
                <div class="button-group">
                      <a class="minibutton js-entice" href=""
                         data-entice="You must be signed in and on a branch to make or propose changes">Edit</a>
                  <a href="/anthonymonori/BelmanProject/raw/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI/SettingsFrame.java" class="button minibutton " id="raw-url">Raw</a>
                    <a href="/anthonymonori/BelmanProject/blame/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI/SettingsFrame.java" class="button minibutton ">Blame</a>
                  <a href="/anthonymonori/BelmanProject/commits/07a4295057b369db23459139b9ebbf55e177f385/src/dk/easv/belman/GUI/SettingsFrame.java" class="button minibutton " rel="nofollow">History</a>
                </div><!-- /.button-group -->
              </div><!-- /.actions -->

            </div>
                <div class="blob-wrapper data type-java js-blob-data">
      <table class="file-code file-diff">
        <tr class="file-code-line">
          <td class="blob-line-nums">
            <span id="L1" rel="#L1">1</span>
<span id="L2" rel="#L2">2</span>
<span id="L3" rel="#L3">3</span>
<span id="L4" rel="#L4">4</span>
<span id="L5" rel="#L5">5</span>
<span id="L6" rel="#L6">6</span>
<span id="L7" rel="#L7">7</span>
<span id="L8" rel="#L8">8</span>
<span id="L9" rel="#L9">9</span>
<span id="L10" rel="#L10">10</span>
<span id="L11" rel="#L11">11</span>
<span id="L12" rel="#L12">12</span>
<span id="L13" rel="#L13">13</span>
<span id="L14" rel="#L14">14</span>
<span id="L15" rel="#L15">15</span>
<span id="L16" rel="#L16">16</span>
<span id="L17" rel="#L17">17</span>
<span id="L18" rel="#L18">18</span>
<span id="L19" rel="#L19">19</span>
<span id="L20" rel="#L20">20</span>
<span id="L21" rel="#L21">21</span>
<span id="L22" rel="#L22">22</span>
<span id="L23" rel="#L23">23</span>
<span id="L24" rel="#L24">24</span>
<span id="L25" rel="#L25">25</span>
<span id="L26" rel="#L26">26</span>
<span id="L27" rel="#L27">27</span>
<span id="L28" rel="#L28">28</span>
<span id="L29" rel="#L29">29</span>
<span id="L30" rel="#L30">30</span>
<span id="L31" rel="#L31">31</span>
<span id="L32" rel="#L32">32</span>
<span id="L33" rel="#L33">33</span>
<span id="L34" rel="#L34">34</span>
<span id="L35" rel="#L35">35</span>
<span id="L36" rel="#L36">36</span>
<span id="L37" rel="#L37">37</span>
<span id="L38" rel="#L38">38</span>
<span id="L39" rel="#L39">39</span>
<span id="L40" rel="#L40">40</span>
<span id="L41" rel="#L41">41</span>
<span id="L42" rel="#L42">42</span>
<span id="L43" rel="#L43">43</span>
<span id="L44" rel="#L44">44</span>
<span id="L45" rel="#L45">45</span>
<span id="L46" rel="#L46">46</span>
<span id="L47" rel="#L47">47</span>
<span id="L48" rel="#L48">48</span>
<span id="L49" rel="#L49">49</span>
<span id="L50" rel="#L50">50</span>
<span id="L51" rel="#L51">51</span>
<span id="L52" rel="#L52">52</span>
<span id="L53" rel="#L53">53</span>
<span id="L54" rel="#L54">54</span>
<span id="L55" rel="#L55">55</span>
<span id="L56" rel="#L56">56</span>
<span id="L57" rel="#L57">57</span>
<span id="L58" rel="#L58">58</span>
<span id="L59" rel="#L59">59</span>
<span id="L60" rel="#L60">60</span>
<span id="L61" rel="#L61">61</span>
<span id="L62" rel="#L62">62</span>
<span id="L63" rel="#L63">63</span>
<span id="L64" rel="#L64">64</span>
<span id="L65" rel="#L65">65</span>
<span id="L66" rel="#L66">66</span>
<span id="L67" rel="#L67">67</span>
<span id="L68" rel="#L68">68</span>
<span id="L69" rel="#L69">69</span>
<span id="L70" rel="#L70">70</span>
<span id="L71" rel="#L71">71</span>
<span id="L72" rel="#L72">72</span>
<span id="L73" rel="#L73">73</span>
<span id="L74" rel="#L74">74</span>
<span id="L75" rel="#L75">75</span>
<span id="L76" rel="#L76">76</span>
<span id="L77" rel="#L77">77</span>
<span id="L78" rel="#L78">78</span>
<span id="L79" rel="#L79">79</span>
<span id="L80" rel="#L80">80</span>
<span id="L81" rel="#L81">81</span>
<span id="L82" rel="#L82">82</span>
<span id="L83" rel="#L83">83</span>
<span id="L84" rel="#L84">84</span>
<span id="L85" rel="#L85">85</span>
<span id="L86" rel="#L86">86</span>
<span id="L87" rel="#L87">87</span>
<span id="L88" rel="#L88">88</span>
<span id="L89" rel="#L89">89</span>
<span id="L90" rel="#L90">90</span>
<span id="L91" rel="#L91">91</span>
<span id="L92" rel="#L92">92</span>
<span id="L93" rel="#L93">93</span>
<span id="L94" rel="#L94">94</span>
<span id="L95" rel="#L95">95</span>
<span id="L96" rel="#L96">96</span>
<span id="L97" rel="#L97">97</span>
<span id="L98" rel="#L98">98</span>
<span id="L99" rel="#L99">99</span>
<span id="L100" rel="#L100">100</span>
<span id="L101" rel="#L101">101</span>
<span id="L102" rel="#L102">102</span>
<span id="L103" rel="#L103">103</span>
<span id="L104" rel="#L104">104</span>
<span id="L105" rel="#L105">105</span>
<span id="L106" rel="#L106">106</span>
<span id="L107" rel="#L107">107</span>
<span id="L108" rel="#L108">108</span>
<span id="L109" rel="#L109">109</span>
<span id="L110" rel="#L110">110</span>
<span id="L111" rel="#L111">111</span>
<span id="L112" rel="#L112">112</span>
<span id="L113" rel="#L113">113</span>
<span id="L114" rel="#L114">114</span>
<span id="L115" rel="#L115">115</span>
<span id="L116" rel="#L116">116</span>
<span id="L117" rel="#L117">117</span>
<span id="L118" rel="#L118">118</span>
<span id="L119" rel="#L119">119</span>
<span id="L120" rel="#L120">120</span>
<span id="L121" rel="#L121">121</span>
<span id="L122" rel="#L122">122</span>
<span id="L123" rel="#L123">123</span>
<span id="L124" rel="#L124">124</span>
<span id="L125" rel="#L125">125</span>
<span id="L126" rel="#L126">126</span>
<span id="L127" rel="#L127">127</span>
<span id="L128" rel="#L128">128</span>
<span id="L129" rel="#L129">129</span>
<span id="L130" rel="#L130">130</span>
<span id="L131" rel="#L131">131</span>
<span id="L132" rel="#L132">132</span>
<span id="L133" rel="#L133">133</span>
<span id="L134" rel="#L134">134</span>
<span id="L135" rel="#L135">135</span>
<span id="L136" rel="#L136">136</span>
<span id="L137" rel="#L137">137</span>
<span id="L138" rel="#L138">138</span>
<span id="L139" rel="#L139">139</span>
<span id="L140" rel="#L140">140</span>
<span id="L141" rel="#L141">141</span>
<span id="L142" rel="#L142">142</span>
<span id="L143" rel="#L143">143</span>
<span id="L144" rel="#L144">144</span>
<span id="L145" rel="#L145">145</span>
<span id="L146" rel="#L146">146</span>
<span id="L147" rel="#L147">147</span>
<span id="L148" rel="#L148">148</span>
<span id="L149" rel="#L149">149</span>
<span id="L150" rel="#L150">150</span>
<span id="L151" rel="#L151">151</span>
<span id="L152" rel="#L152">152</span>
<span id="L153" rel="#L153">153</span>
<span id="L154" rel="#L154">154</span>
<span id="L155" rel="#L155">155</span>
<span id="L156" rel="#L156">156</span>
<span id="L157" rel="#L157">157</span>
<span id="L158" rel="#L158">158</span>
<span id="L159" rel="#L159">159</span>
<span id="L160" rel="#L160">160</span>
<span id="L161" rel="#L161">161</span>
<span id="L162" rel="#L162">162</span>
<span id="L163" rel="#L163">163</span>
<span id="L164" rel="#L164">164</span>
<span id="L165" rel="#L165">165</span>
<span id="L166" rel="#L166">166</span>
<span id="L167" rel="#L167">167</span>
<span id="L168" rel="#L168">168</span>
<span id="L169" rel="#L169">169</span>
<span id="L170" rel="#L170">170</span>
<span id="L171" rel="#L171">171</span>
<span id="L172" rel="#L172">172</span>
<span id="L173" rel="#L173">173</span>
<span id="L174" rel="#L174">174</span>
<span id="L175" rel="#L175">175</span>
<span id="L176" rel="#L176">176</span>
<span id="L177" rel="#L177">177</span>
<span id="L178" rel="#L178">178</span>
<span id="L179" rel="#L179">179</span>
<span id="L180" rel="#L180">180</span>
<span id="L181" rel="#L181">181</span>
<span id="L182" rel="#L182">182</span>
<span id="L183" rel="#L183">183</span>
<span id="L184" rel="#L184">184</span>
<span id="L185" rel="#L185">185</span>
<span id="L186" rel="#L186">186</span>
<span id="L187" rel="#L187">187</span>
<span id="L188" rel="#L188">188</span>
<span id="L189" rel="#L189">189</span>
<span id="L190" rel="#L190">190</span>
<span id="L191" rel="#L191">191</span>
<span id="L192" rel="#L192">192</span>
<span id="L193" rel="#L193">193</span>
<span id="L194" rel="#L194">194</span>
<span id="L195" rel="#L195">195</span>
<span id="L196" rel="#L196">196</span>
<span id="L197" rel="#L197">197</span>

          </td>
          <td class="blob-line-code">
                  <div class="highlight"><pre><div class='line' id='LC1'><span class="cm">/*</span></div><div class='line' id='LC2'><span class="cm"> * To change this template, choose Tools | Templates</span></div><div class='line' id='LC3'><span class="cm"> * and open the template in the editor.</span></div><div class='line' id='LC4'><span class="cm"> */</span></div><div class='line' id='LC5'><span class="kn">package</span> <span class="n">dk</span><span class="o">.</span><span class="na">easv</span><span class="o">.</span><span class="na">belman</span><span class="o">.</span><span class="na">GUI</span><span class="o">;</span></div><div class='line' id='LC6'><br/></div><div class='line' id='LC7'><span class="cm">/**</span></div><div class='line' id='LC8'><span class="cm"> *</span></div><div class='line' id='LC9'><span class="cm"> * @author Dani</span></div><div class='line' id='LC10'><span class="cm"> */</span></div><div class='line' id='LC11'><span class="kd">public</span> <span class="kd">class</span> <span class="nc">SettingsFrame</span> <span class="kd">extends</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JFrame</span> <span class="o">{</span></div><div class='line' id='LC12'><br/></div><div class='line' id='LC13'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC14'><span class="cm">     * Creates new form SettingsFrame</span></div><div class='line' id='LC15'><span class="cm">     */</span></div><div class='line' id='LC16'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="nf">SettingsFrame</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC17'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">initComponents</span><span class="o">();</span></div><div class='line' id='LC18'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC19'><br/></div><div class='line' id='LC20'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC21'><span class="cm">     * This method is called from within the constructor to initialize the form.</span></div><div class='line' id='LC22'><span class="cm">     * WARNING: Do NOT modify this code. The content of this method is always</span></div><div class='line' id='LC23'><span class="cm">     * regenerated by the Form Editor.</span></div><div class='line' id='LC24'><span class="cm">     */</span></div><div class='line' id='LC25'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="nd">@SuppressWarnings</span><span class="o">(</span><span class="s">&quot;unchecked&quot;</span><span class="o">)</span></div><div class='line' id='LC26'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// &lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot;Generated Code&quot;&gt;//GEN-BEGIN:initComponents</span></div><div class='line' id='LC27'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="kt">void</span> <span class="nf">initComponents</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC28'><br/></div><div class='line' id='LC29'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel1</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span><span class="o">();</span></div><div class='line' id='LC30'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jSpinner1</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span><span class="o">();</span></div><div class='line' id='LC31'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jSpinner2</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span><span class="o">();</span></div><div class='line' id='LC32'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jSpinner3</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span><span class="o">();</span></div><div class='line' id='LC33'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jSpinner4</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span><span class="o">();</span></div><div class='line' id='LC34'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel2</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span><span class="o">();</span></div><div class='line' id='LC35'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel3</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span><span class="o">();</span></div><div class='line' id='LC36'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel4</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span><span class="o">();</span></div><div class='line' id='LC37'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jColorChooser1</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JColorChooser</span><span class="o">();</span></div><div class='line' id='LC38'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel5</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span><span class="o">();</span></div><div class='line' id='LC39'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jSpinner5</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span><span class="o">();</span></div><div class='line' id='LC40'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel6</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span><span class="o">();</span></div><div class='line' id='LC41'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JPanel</span><span class="o">();</span></div><div class='line' id='LC42'><br/></div><div class='line' id='LC43'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">setDefaultCloseOperation</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">WindowConstants</span><span class="o">.</span><span class="na">EXIT_ON_CLOSE</span><span class="o">);</span></div><div class='line' id='LC44'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">setResizable</span><span class="o">(</span><span class="kc">false</span><span class="o">);</span></div><div class='line' id='LC45'><br/></div><div class='line' id='LC46'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel1</span><span class="o">.</span><span class="na">setHorizontalAlignment</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">SwingConstants</span><span class="o">.</span><span class="na">RIGHT</span><span class="o">);</span></div><div class='line' id='LC47'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel1</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Order refresh period (minute)&quot;</span><span class="o">);</span></div><div class='line' id='LC48'><br/></div><div class='line' id='LC49'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel2</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Time to cut a sleeve with 0.2 mm thickness (sec)&quot;</span><span class="o">);</span></div><div class='line' id='LC50'><br/></div><div class='line' id='LC51'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel3</span><span class="o">.</span><span class="na">setHorizontalAlignment</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">SwingConstants</span><span class="o">.</span><span class="na">RIGHT</span><span class="o">);</span></div><div class='line' id='LC52'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel3</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Time to cut a sleeve with 10 mm thickness (sec)&quot;</span><span class="o">);</span></div><div class='line' id='LC53'><br/></div><div class='line' id='LC54'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel4</span><span class="o">.</span><span class="na">setHorizontalAlignment</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">SwingConstants</span><span class="o">.</span><span class="na">RIGHT</span><span class="o">);</span></div><div class='line' id='LC55'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel4</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Time to change a coil (minutes)&quot;</span><span class="o">);</span></div><div class='line' id='LC56'><br/></div><div class='line' id='LC57'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel5</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;An order is urgent if it&#39;s within (days)&quot;</span><span class="o">);</span></div><div class='line' id='LC58'><br/></div><div class='line' id='LC59'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jLabel6</span><span class="o">.</span><span class="na">setText</span><span class="o">(</span><span class="s">&quot;Urgent order color&quot;</span><span class="o">);</span></div><div class='line' id='LC60'><br/></div><div class='line' id='LC61'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1</span><span class="o">.</span><span class="na">setBackground</span><span class="o">(</span><span class="k">new</span> <span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">Color</span><span class="o">(</span><span class="mi">255</span><span class="o">,</span> <span class="mi">0</span><span class="o">,</span> <span class="mi">0</span><span class="o">));</span></div><div class='line' id='LC62'><br/></div><div class='line' id='LC63'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span> <span class="n">jPanel1Layout</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">(</span><span class="n">jPanel1</span><span class="o">);</span></div><div class='line' id='LC64'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1</span><span class="o">.</span><span class="na">setLayout</span><span class="o">(</span><span class="n">jPanel1Layout</span><span class="o">);</span></div><div class='line' id='LC65'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1Layout</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span></div><div class='line' id='LC66'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1Layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC67'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">80</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC68'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC69'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1Layout</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span></div><div class='line' id='LC70'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">jPanel1Layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC71'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">0</span><span class="o">,</span> <span class="mi">20</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC72'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC73'><br/></div><div class='line' id='LC74'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span> <span class="n">layout</span> <span class="o">=</span> <span class="k">new</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">(</span><span class="n">getContentPane</span><span class="o">());</span></div><div class='line' id='LC75'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">getContentPane</span><span class="o">().</span><span class="na">setLayout</span><span class="o">(</span><span class="n">layout</span><span class="o">);</span></div><div class='line' id='LC76'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">layout</span><span class="o">.</span><span class="na">setHorizontalGroup</span><span class="o">(</span></div><div class='line' id='LC77'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC78'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC79'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">88</span><span class="o">,</span> <span class="mi">88</span><span class="o">,</span> <span class="mi">88</span><span class="o">)</span></div><div class='line' id='LC80'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">)</span></div><div class='line' id='LC81'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC82'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel3</span><span class="o">)</span></div><div class='line' id='LC83'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">)</span></div><div class='line' id='LC84'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner3</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="mi">80</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">))</span></div><div class='line' id='LC85'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC86'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC87'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel2</span><span class="o">)</span></div><div class='line' id='LC88'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">)</span></div><div class='line' id='LC89'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner2</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="mi">80</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">))</span></div><div class='line' id='LC90'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC91'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">89</span><span class="o">,</span> <span class="mi">89</span><span class="o">,</span> <span class="mi">89</span><span class="o">)</span></div><div class='line' id='LC92'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel1</span><span class="o">)</span></div><div class='line' id='LC93'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">)</span></div><div class='line' id='LC94'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner1</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="mi">80</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)))</span></div><div class='line' id='LC95'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC96'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">)</span></div><div class='line' id='LC97'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel5</span><span class="o">)</span></div><div class='line' id='LC98'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel4</span><span class="o">))</span></div><div class='line' id='LC99'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">)</span></div><div class='line' id='LC100'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">,</span> <span class="kc">false</span><span class="o">)</span></div><div class='line' id='LC101'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner5</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">)</span></div><div class='line' id='LC102'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner4</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="mi">80</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)))</span></div><div class='line' id='LC103'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC104'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel6</span><span class="o">)</span></div><div class='line' id='LC105'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">,</span> <span class="mi">18</span><span class="o">)</span></div><div class='line' id='LC106'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jPanel1</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)))</span></div><div class='line' id='LC107'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addContainerGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">))</span></div><div class='line' id='LC108'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">TRAILING</span><span class="o">,</span> <span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC109'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addContainerGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">)</span></div><div class='line' id='LC110'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jColorChooser1</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="mi">613</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC111'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addContainerGap</span><span class="o">())</span></div><div class='line' id='LC112'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC113'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">layout</span><span class="o">.</span><span class="na">setVerticalGroup</span><span class="o">(</span></div><div class='line' id='LC114'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC115'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createSequentialGroup</span><span class="o">()</span></div><div class='line' id='LC116'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addContainerGap</span><span class="o">()</span></div><div class='line' id='LC117'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">BASELINE</span><span class="o">)</span></div><div class='line' id='LC118'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel1</span><span class="o">)</span></div><div class='line' id='LC119'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner1</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">))</span></div><div class='line' id='LC120'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGap</span><span class="o">(</span><span class="mi">6</span><span class="o">,</span> <span class="mi">6</span><span class="o">,</span> <span class="mi">6</span><span class="o">)</span></div><div class='line' id='LC121'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">BASELINE</span><span class="o">)</span></div><div class='line' id='LC122'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner2</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC123'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel2</span><span class="o">))</span></div><div class='line' id='LC124'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addPreferredGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">LayoutStyle</span><span class="o">.</span><span class="na">ComponentPlacement</span><span class="o">.</span><span class="na">RELATED</span><span class="o">)</span></div><div class='line' id='LC125'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">BASELINE</span><span class="o">)</span></div><div class='line' id='LC126'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner3</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC127'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel3</span><span class="o">))</span></div><div class='line' id='LC128'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addPreferredGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">LayoutStyle</span><span class="o">.</span><span class="na">ComponentPlacement</span><span class="o">.</span><span class="na">RELATED</span><span class="o">)</span></div><div class='line' id='LC129'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">BASELINE</span><span class="o">)</span></div><div class='line' id='LC130'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner4</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC131'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel4</span><span class="o">))</span></div><div class='line' id='LC132'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addPreferredGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">LayoutStyle</span><span class="o">.</span><span class="na">ComponentPlacement</span><span class="o">.</span><span class="na">RELATED</span><span class="o">)</span></div><div class='line' id='LC133'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">BASELINE</span><span class="o">)</span></div><div class='line' id='LC134'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jSpinner5</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC135'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel5</span><span class="o">))</span></div><div class='line' id='LC136'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addPreferredGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">LayoutStyle</span><span class="o">.</span><span class="na">ComponentPlacement</span><span class="o">.</span><span class="na">RELATED</span><span class="o">)</span></div><div class='line' id='LC137'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addGroup</span><span class="o">(</span><span class="n">layout</span><span class="o">.</span><span class="na">createParallelGroup</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">Alignment</span><span class="o">.</span><span class="na">LEADING</span><span class="o">)</span></div><div class='line' id='LC138'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jPanel1</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC139'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jLabel6</span><span class="o">))</span></div><div class='line' id='LC140'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addPreferredGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">LayoutStyle</span><span class="o">.</span><span class="na">ComponentPlacement</span><span class="o">.</span><span class="na">RELATED</span><span class="o">)</span></div><div class='line' id='LC141'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addComponent</span><span class="o">(</span><span class="n">jColorChooser1</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">,</span> <span class="mi">328</span><span class="o">,</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">PREFERRED_SIZE</span><span class="o">)</span></div><div class='line' id='LC142'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">.</span><span class="na">addContainerGap</span><span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">GroupLayout</span><span class="o">.</span><span class="na">DEFAULT_SIZE</span><span class="o">,</span> <span class="n">Short</span><span class="o">.</span><span class="na">MAX_VALUE</span><span class="o">))</span></div><div class='line' id='LC143'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">);</span></div><div class='line' id='LC144'><br/></div><div class='line' id='LC145'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">pack</span><span class="o">();</span></div><div class='line' id='LC146'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span><span class="c1">// &lt;/editor-fold&gt;//GEN-END:initComponents</span></div><div class='line' id='LC147'><br/></div><div class='line' id='LC148'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/**</span></div><div class='line' id='LC149'><span class="cm">     * @param args the command line arguments</span></div><div class='line' id='LC150'><span class="cm">     */</span></div><div class='line' id='LC151'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kd">static</span> <span class="kt">void</span> <span class="nf">main</span><span class="o">(</span><span class="n">String</span> <span class="n">args</span><span class="o">[])</span> <span class="o">{</span></div><div class='line' id='LC152'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* Set the Nimbus look and feel */</span></div><div class='line' id='LC153'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">//&lt;editor-fold defaultstate=&quot;collapsed&quot; desc=&quot; Look and feel setting code (optional) &quot;&gt;</span></div><div class='line' id='LC154'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.</span></div><div class='line' id='LC155'><span class="cm">         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html</span></div><div class='line' id='LC156'><span class="cm">         */</span></div><div class='line' id='LC157'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">try</span> <span class="o">{</span></div><div class='line' id='LC158'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">for</span> <span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">UIManager</span><span class="o">.</span><span class="na">LookAndFeelInfo</span> <span class="n">info</span> <span class="o">:</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">UIManager</span><span class="o">.</span><span class="na">getInstalledLookAndFeels</span><span class="o">())</span> <span class="o">{</span></div><div class='line' id='LC159'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">if</span> <span class="o">(</span><span class="s">&quot;Nimbus&quot;</span><span class="o">.</span><span class="na">equals</span><span class="o">(</span><span class="n">info</span><span class="o">.</span><span class="na">getName</span><span class="o">()))</span> <span class="o">{</span></div><div class='line' id='LC160'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">UIManager</span><span class="o">.</span><span class="na">setLookAndFeel</span><span class="o">(</span><span class="n">info</span><span class="o">.</span><span class="na">getClassName</span><span class="o">());</span></div><div class='line' id='LC161'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">break</span><span class="o">;</span></div><div class='line' id='LC162'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC163'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC164'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">ClassNotFoundException</span> <span class="n">ex</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC165'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Logger</span><span class="o">.</span><span class="na">getLogger</span><span class="o">(</span><span class="n">SettingsFrame</span><span class="o">.</span><span class="na">class</span><span class="o">.</span><span class="na">getName</span><span class="o">()).</span><span class="na">log</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Level</span><span class="o">.</span><span class="na">SEVERE</span><span class="o">,</span> <span class="kc">null</span><span class="o">,</span> <span class="n">ex</span><span class="o">);</span></div><div class='line' id='LC166'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">InstantiationException</span> <span class="n">ex</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC167'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Logger</span><span class="o">.</span><span class="na">getLogger</span><span class="o">(</span><span class="n">SettingsFrame</span><span class="o">.</span><span class="na">class</span><span class="o">.</span><span class="na">getName</span><span class="o">()).</span><span class="na">log</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Level</span><span class="o">.</span><span class="na">SEVERE</span><span class="o">,</span> <span class="kc">null</span><span class="o">,</span> <span class="n">ex</span><span class="o">);</span></div><div class='line' id='LC168'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">IllegalAccessException</span> <span class="n">ex</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC169'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Logger</span><span class="o">.</span><span class="na">getLogger</span><span class="o">(</span><span class="n">SettingsFrame</span><span class="o">.</span><span class="na">class</span><span class="o">.</span><span class="na">getName</span><span class="o">()).</span><span class="na">log</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Level</span><span class="o">.</span><span class="na">SEVERE</span><span class="o">,</span> <span class="kc">null</span><span class="o">,</span> <span class="n">ex</span><span class="o">);</span></div><div class='line' id='LC170'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span> <span class="k">catch</span> <span class="o">(</span><span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">UnsupportedLookAndFeelException</span> <span class="n">ex</span><span class="o">)</span> <span class="o">{</span></div><div class='line' id='LC171'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Logger</span><span class="o">.</span><span class="na">getLogger</span><span class="o">(</span><span class="n">SettingsFrame</span><span class="o">.</span><span class="na">class</span><span class="o">.</span><span class="na">getName</span><span class="o">()).</span><span class="na">log</span><span class="o">(</span><span class="n">java</span><span class="o">.</span><span class="na">util</span><span class="o">.</span><span class="na">logging</span><span class="o">.</span><span class="na">Level</span><span class="o">.</span><span class="na">SEVERE</span><span class="o">,</span> <span class="kc">null</span><span class="o">,</span> <span class="n">ex</span><span class="o">);</span></div><div class='line' id='LC172'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC173'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">//&lt;/editor-fold&gt;</span></div><div class='line' id='LC174'><br/></div><div class='line' id='LC175'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="cm">/* Create and display the form */</span></div><div class='line' id='LC176'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="n">java</span><span class="o">.</span><span class="na">awt</span><span class="o">.</span><span class="na">EventQueue</span><span class="o">.</span><span class="na">invokeLater</span><span class="o">(</span><span class="k">new</span> <span class="n">Runnable</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC177'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">public</span> <span class="kt">void</span> <span class="nf">run</span><span class="o">()</span> <span class="o">{</span></div><div class='line' id='LC178'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="k">new</span> <span class="nf">SettingsFrame</span><span class="o">().</span><span class="na">setVisible</span><span class="o">(</span><span class="kc">true</span><span class="o">);</span></div><div class='line' id='LC179'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC180'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">});</span></div><div class='line' id='LC181'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="o">}</span></div><div class='line' id='LC182'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// Variables declaration - do not modify//GEN-BEGIN:variables</span></div><div class='line' id='LC183'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JColorChooser</span> <span class="n">jColorChooser1</span><span class="o">;</span></div><div class='line' id='LC184'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span> <span class="n">jLabel1</span><span class="o">;</span></div><div class='line' id='LC185'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span> <span class="n">jLabel2</span><span class="o">;</span></div><div class='line' id='LC186'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span> <span class="n">jLabel3</span><span class="o">;</span></div><div class='line' id='LC187'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span> <span class="n">jLabel4</span><span class="o">;</span></div><div class='line' id='LC188'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span> <span class="n">jLabel5</span><span class="o">;</span></div><div class='line' id='LC189'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JLabel</span> <span class="n">jLabel6</span><span class="o">;</span></div><div class='line' id='LC190'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JPanel</span> <span class="n">jPanel1</span><span class="o">;</span></div><div class='line' id='LC191'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span> <span class="n">jSpinner1</span><span class="o">;</span></div><div class='line' id='LC192'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span> <span class="n">jSpinner2</span><span class="o">;</span></div><div class='line' id='LC193'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span> <span class="n">jSpinner3</span><span class="o">;</span></div><div class='line' id='LC194'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span> <span class="n">jSpinner4</span><span class="o">;</span></div><div class='line' id='LC195'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="kd">private</span> <span class="n">javax</span><span class="o">.</span><span class="na">swing</span><span class="o">.</span><span class="na">JSpinner</span> <span class="n">jSpinner5</span><span class="o">;</span></div><div class='line' id='LC196'>&nbsp;&nbsp;&nbsp;&nbsp;<span class="c1">// End of variables declaration//GEN-END:variables</span></div><div class='line' id='LC197'><span class="o">}</span></div></pre></div>
          </td>
        </tr>
      </table>
  </div>

          </div>
        </div>

        <a href="#jump-to-line" rel="facebox" data-hotkey="l" class="js-jump-to-line" style="display:none">Jump to Line</a>
        <div id="jump-to-line" style="display:none">
          <h2>Jump to Line</h2>
          <form accept-charset="UTF-8" class="js-jump-to-line-form">
            <input class="textfield js-jump-to-line-field" type="text">
            <div class="full-button">
              <button type="submit" class="button">Go</button>
            </div>
          </form>
        </div>

      </div>
    </div>
</div>

<div id="js-frame-loading-template" class="frame frame-loading large-loading-area" style="display:none;">
  <img class="js-frame-loading-spinner" src="https://a248.e.akamai.net/assets.github.com/images/spinners/octocat-spinner-128.gif?1360648847" height="64" width="64">
</div>


        </div>
      </div>
      <div class="modal-backdrop"></div>
    </div>

      <div id="footer-push"></div><!-- hack for sticky footer -->
    </div><!-- end of wrapper - hack for sticky footer -->

      <!-- footer -->
      <div id="footer">
  <div class="container clearfix">

      <dl class="footer_nav">
        <dt>GitHub</dt>
        <dd><a href="/about">About us</a></dd>
        <dd><a href="/blog">Blog</a></dd>
        <dd><a href="/contact">Contact &amp; support</a></dd>
        <dd><a href="http://enterprise.github.com/">GitHub Enterprise</a></dd>
        <dd><a href="http://status.github.com/">Site status</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>Applications</dt>
        <dd><a href="http://mac.github.com/">GitHub for Mac</a></dd>
        <dd><a href="http://windows.github.com/">GitHub for Windows</a></dd>
        <dd><a href="http://eclipse.github.com/">GitHub for Eclipse</a></dd>
        <dd><a href="http://mobile.github.com/">GitHub mobile apps</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>Services</dt>
        <dd><a href="http://get.gaug.es/">Gauges: Web analytics</a></dd>
        <dd><a href="http://speakerdeck.com">Speaker Deck: Presentations</a></dd>
        <dd><a href="https://gist.github.com">Gist: Code snippets</a></dd>
        <dd><a href="http://jobs.github.com/">Job board</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>Documentation</dt>
        <dd><a href="http://help.github.com/">GitHub Help</a></dd>
        <dd><a href="http://developer.github.com/">Developer API</a></dd>
        <dd><a href="http://github.github.com/github-flavored-markdown/">GitHub Flavored Markdown</a></dd>
        <dd><a href="http://pages.github.com/">GitHub Pages</a></dd>
      </dl>

      <dl class="footer_nav">
        <dt>More</dt>
        <dd><a href="http://training.github.com/">Training</a></dd>
        <dd><a href="/edu">Students &amp; teachers</a></dd>
        <dd><a href="http://shop.github.com">The Shop</a></dd>
        <dd><a href="/plans">Plans &amp; pricing</a></dd>
        <dd><a href="http://octodex.github.com/">The Octodex</a></dd>
      </dl>

      <hr class="footer-divider">


    <p class="right">&copy; 2013 <span title="0.21424s from fe4.rs.github.com">GitHub</span>, Inc. All rights reserved.</p>
    <a class="left" href="/">
      <span class="mega-octicon octicon-mark-github"></span>
    </a>
    <ul id="legal">
        <li><a href="/site/terms">Terms of Service</a></li>
        <li><a href="/site/privacy">Privacy</a></li>
        <li><a href="/security">Security</a></li>
    </ul>

  </div><!-- /.container -->

</div><!-- /.#footer -->


    <div class="fullscreen-overlay js-fullscreen-overlay" id="fullscreen_overlay">
  <div class="fullscreen-container js-fullscreen-container">
    <div class="textarea-wrap">
      <textarea name="fullscreen-contents" id="fullscreen-contents" class="js-fullscreen-contents" placeholder="" data-suggester="fullscreen_suggester"></textarea>
          <div class="suggester-container">
              <div class="suggester fullscreen-suggester js-navigation-container" id="fullscreen_suggester"
                 data-url="/anthonymonori/BelmanProject/suggestions/commit">
              </div>
          </div>
    </div>
  </div>
  <div class="fullscreen-sidebar">
    <a href="#" class="exit-fullscreen js-exit-fullscreen tooltipped leftwards" title="Exit Zen Mode">
      <span class="mega-octicon octicon-screen-normal"></span>
    </a>
    <a href="#" class="theme-switcher js-theme-switcher tooltipped leftwards"
      title="Switch themes">
      <span class="octicon octicon-color-mode"></span>
    </a>
  </div>
</div>



    <div id="ajax-error-message" class="flash flash-error">
      <span class="octicon octicon-alert"></span>
      Something went wrong with that request. Please try again.
      <a href="#" class="octicon octicon-remove-close ajax-error-dismiss"></a>
    </div>

    
    <span id='server_response_time' data-time='0.21484' data-host='fe4'></span>
    
  </body>
</html>

