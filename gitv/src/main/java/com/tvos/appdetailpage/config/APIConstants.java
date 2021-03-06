package com.tvos.appdetailpage.config;

public interface APIConstants {
    public static final int APKFILE_EXIST = 1;
    public static final int APK_DOWNLOADING = 0;
    public static final long APK_FILE_SIZE = 0;
    public static final String APPBACKEND_ENDPOINT = "http://store.ptqy.gitv.tv";
    public static final String APPDETAIL_FIELDS = "basic,res";
    public static final int AS_DEFAULT_COUNT = 21;
    public static final String BLOCK_ADVER = "banner";
    public static final String BLOCK_ALL_APP_LIST = "all_applist";
    public static final String BLOCK_ALL_GAME = "all_game";
    public static final String BLOCK_ALL_LIST = "all_list";
    public static final String BLOCK_APP = "app";
    public static final String BLOCK_APP_LIST = "app_list";
    public static final String BLOCK_CATE_GAME_LIST = "cate_game_list";
    public static final String BLOCK_CATE_LIST = "cate_list";
    public static final String BLOCK_CLEAR = "dedone";
    public static final String BLOCK_DETAIL = "detail";
    public static final String BLOCK_DOWNLOAD = "download";
    public static final String BLOCK_GAME = "game";
    public static final String BLOCK_GAME_LIST = "game_list";
    public static final String BLOCK_HOME = "home";
    public static final String BLOCK_INSTALL = "install";
    public static final String BLOCK_INSTALLED_APP = "my_app";
    public static final String BLOCK_INSTALLED_APP_PG = "installedpg";
    public static final String BLOCK_LAUNCH = "boot";
    public static final String BLOCK_LOGIN = "login";
    public static final String BLOCK_MY = "my";
    public static final String BLOCK_MY_ACCOUNT = "my_id";
    public static final String BLOCK_MY_APP = "my_app";
    public static final String BLOCK_MY_CATEGORY = "my_list";
    public static final String BLOCK_OPEN = "open";
    public static final String BLOCK_PREVIEW = "preview";
    public static final String BLOCK_RECOMMEND = "recommend";
    public static final String BLOCK_RECOMMENDED = "recommended";
    public static final String BLOCK_REMOVE = "remove";
    public static final String BLOCK_SEARCH = "search";
    public static final String BLOCK_SEARCH_RESULT = "search_result";
    public static final String BLOCK_SEARCH_TEXT = "search_text";
    public static final String BLOCK_SEARCH_VIEW = "search_view";
    public static final String BLOCK_STICKY = "sticky";
    public static final String BLOCK_TOPIC = "topicpg";
    public static final String BLOCK_UPDATE = "update";
    public static final int BROADCAST_APP_UPDATE = 2;
    public static final int BROADCAST_CLEAR_APP = 8;
    public static final int BROADCAST_DOWNLOAD_APP = 7;
    public static final String BROADCAST_EXTRA_BUNDLE = "bundle";
    public static final String BROADCAST_EXTRA_COMM = "com.gitv.receiver";
    public static final String BROADCAST_EXTRA_PKG_NAME = "app_package_name";
    public static final String BROADCAST_EXTRA_PKG_PATH = "app_package_path";
    public static final String BROADCAST_EXTRA_VERSION = "version";
    public static final String BROADCAST_FILTER_ACTION = "com.gitv.tvappstore.home.CHECK_UPDATE_ACTION";
    public static final int BROADCAST_INSTALL_APP = 9;
    public static final int BROADCAST_LOADDATA_COMPLETE = 1;
    public static final int BROADCAST_NETSTATE_ERROR = 4;
    public static final int BROADCAST_NETSTATE_NONE = 3;
    public static final int BROADCAST_OPEN_APP = 5;
    public static final int BROADCAST_REQUEST_FAIL = 0;
    public static final int BROADCAST_STICK_APP = 6;
    public static final int BROADCAST_UNINSTALL_APP = 10;
    public static final String BUNDLE_EXTRA_CATEGORYT = "category";
    public static final String BUNDLE_EXTRA_DETAILAPP = "singleAppInfo";
    public static final String BUNDLE_EXTRA_DETAILAPP_APPID = "appid";
    public static final String BUNDLE_EXTRA_DETAILAPP_APP_PKG = "apppackagename";
    public static final String BUNDLE_EXTRA_DETAILAPP_CLICK = "click";
    public static final String BUNDLE_EXTRA_DETAILAPP_DEVICE_ID = "deviceid";
    public static final String BUNDLE_EXTRA_DETAILAPP_UUID = "uuid";
    public static final String BUNDLE_EXTRA_RETURNINTENTACTIVITYNAME = "returnIntentActivityName";
    public static final String BUNDLE_EXTRA_RETURNINTENTFLAGS = "returnIntentFlags";
    public static final String BUNDLE_EXTRA_RETURNINTENTPKGNAME = "returnIntentPkgName";
    public static final int CATEGORY_ALL = 3;
    public static final int CATEGORY_APP = 2;
    public static final String CATEGORY_FLAG = "category_flag";
    public static final int CATEGORY_GAME = 1;
    public static final int CATEGORY_OTHER = 4;
    public static final String CLOUD_PUSHED_PINGBACK_ENDPOINT = "http://msg.71.am";
    public static final String COLLECTION_ID = "collection_id";
    public static final String COLLECTION_NAME = "collection_name";
    public static final String CUSTOM_PAGE = "custom_page";
    public static final int DOWNLOAD_404 = 4;
    public static final int DOWNLOAD_CANCAL = 3;
    public static final int DOWNLOAD_ERROR = 5;
    public static final int DOWNLOAD_FAILED = 2;
    public static final int DOWNLOAD_IO = 6;
    public static final int DOWNLOAD_OTHER = 1;
    public static final int DOWNLOAD_RETRY_TIMES = 3;
    public static final int DOWNLOAD_SUCCESS = 0;
    public static final int DOWNLOAD_TIMEOUT = 7;
    public static final String FILECACHE_ADVER_LIST = "iadverdata.dem";
    public static final String FILECACHE_CATEGORY_LIST = "icategorydata.dem";
    public static final String FILECACHE_RECOMMEND_LIST = "irecommendata.dem";
    public static final String FILECACHE_RECOM_CATEGORY_LIST = "irecomcategorydata.dem";
    public static final int HTTP_RESPONSECODE_200 = 200;
    public static final int HTTP_RESPONSECODE_206 = 206;
    public static final int HTTP_RESPONSECODE_404 = 404;
    public static final String ID_CATE_APP = "-1";
    public static final String ID_CATE_GAME = "-2";
    public static final int INIT_FAILURE = 2;
    public static final int IS_HOT = 1;
    public static final String LONGYUAN4_ENDPOINT = "http://msg.ptqy.gitv.tv";
    public static final String LONGYUAN_ENDPOINT = "http://msg.video.ptqy.gitv.tv";
    public static final int MAX_IMAGE_SIZE = 5;
    public static final String NECESSARY_APPS_FLAG = "necessary_apps_flag";
    public static final int NETSTATE_NOMAL = 0;
    public static final int NETSTATE_NONE = -1;
    public static final String PINGBACK_AREA = "t_apple";
    public static final String PINGBACK_ONLISTDONE_MODE = "101";
    public static final String QISO_ENDPOINT = "http://search.video.ptqy.gitv.tv";
    public static final String QIYU_ENDPOINT = "http://qiyu.ptqy.gitv.tv";
    public static final int REQUEST_CATEGORY_PARAM0 = 0;
    public static final int REQUEST_CATEGORY_PARAM1 = 1;
    public static final String RPAGE_ALL_GAME_LIST = "all_gamelist";
    public static final String RPAGE_ALL_LIST = "all_list";
    public static final String RPAGE_CATE_ALL_LIST = "cate_all_list";
    public static final String RPAGE_CATE_GAME_LIST = "cate_game_list";
    public static final String RPAGE_CATE_LIST = "cate_list";
    public static final String RPAGE_CATE_OTHER_LIST = "cate_other_list";
    public static final String RPAGE_DETAIL = "detail";
    public static final String RPAGE_HOME = "home";
    public static final String RPAGE_INSTALLED_APP = "installedpg";
    public static final String RPAGE_LAUNCH = "boot";
    public static final String RPAGE_LOGIN = "login";
    public static final String RPAGE_MY = "my";
    public static final String RPAGE_MY_ACCOUNT = "my_id";
    public static final String RPAGE_SEARCH = "search";
    public static final String RPAGE_TOPIC = "topicpg";
    public static final String RSEAT_CLEAR = "6";
    public static final String RSEAT_CLICK_PRE = "1-";
    public static final String RSEAT_DOWNLOAD = "1";
    public static final String RSEAT_INSTALL = "5";
    public static final String RSEAT_INSTALLED_MENU_CLEAN = "4";
    public static final String RSEAT_INSTALLED_MENU_DETAIL = "2";
    public static final String RSEAT_INSTALLED_MENU_OPEN = "1";
    public static final String RSEAT_INSTALLED_MENU_UNINSTALL = "3";
    public static final String RSEAT_INSTALLED_VISIT = "0";
    public static final String RSEAT_MENU_DETAIL = "detail";
    public static final String RSEAT_MENU_OPEN = "open";
    public static final String RSEAT_MENU_TOP = "top";
    public static final String RSEAT_MENU_UNINSTALL = "uninstall";
    public static final String RSEAT_MENU_UPDATE = "update";
    public static final String RSEAT_ONE = "1";
    public static final String RSEAT_OPEN = "2";
    public static final String RSEAT_REMOVE = "4";
    public static final String RSEAT_STICKY = "7";
    public static final String RSEAT_UPDATE = "3";
    public static final String RSEAT_ZERO = "0";
    public static final String SEARCH_CLICK_NUM_MODE = "13";
    public static final String SEARCH_RELATIVE_MODE = "1";
    public static final int TAB_CATEGORY = 1;
    public static final int TAB_MY_APP = 2;
    public static final int TAB_RECOMMEND = 0;
    public static final int TASK_EXISTS = 3;
    public static final String TV_AGENT_TYPE = "5201";
    public static final int TV_LAUNCHER_CATEGORY = 300301301;
    public static final String TV_UPDATE_ENDPOINT = "http://store.ptqy.gitv.tv";
}
