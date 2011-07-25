package org.kontalk.provider;


import android.net.Uri;
import android.provider.BaseColumns;

public final class MyMessages {
    private MyMessages() {}

    public static final class Messages implements BaseColumns {
        private Messages() {}

        public static final Uri CONTENT_URI = Uri.parse("content://"
                + MessagesProvider.AUTHORITY + "/messages");

        public static final int DIRECTION_IN = 0;
        public static final int DIRECTION_OUT = 1;

        public static final int STATUS_INCOMING = 0;
        public static final int STATUS_SENDING = 1;
        public static final int STATUS_ERROR = 2;
        public static final int STATUS_NOTACCEPTED = 3;
        public static final int STATUS_SENT = 4;
        public static final int STATUS_RECEIVED = 5;
        public static final int STATUS_CONFIRMED = 6;

        /**
         * Builds a message {@link Uri}.
         * @param msgId the message id
         * @return a new message {@link Uri}
         */
        public static Uri getUri(String msgId) {
            return Uri.parse("content://"
                    + MessagesProvider.AUTHORITY + "/messages/" + Uri.encode(msgId));
        }

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/org.kontalk.message";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/org.kontalk.message";

        public static final String THREAD_ID = "thread_id";
        public static final String MESSAGE_ID = "msg_id";
        public static final String REAL_ID = "real_id";
        public static final String PEER = "peer";
        public static final String MIME = "mime";
        public static final String CONTENT = "content";
        public static final String DIRECTION = "direction";
        public static final String UNREAD = "unread";
        public static final String TIMESTAMP = "timestamp";
        public static final String STATUS_CHANGED = "status_changed";
        public static final String STATUS = "status";
        public static final String FETCH_URL = "fetch_url";
        public static final String FETCHED = "fetched";
        public static final String LOCAL_URI = "local_uri";

        // not DESC here because the listview is reverse-stacked
        public static final String DEFAULT_SORT_ORDER = "timestamp";
        public static final String INVERTED_SORT_ORDER = "timestamp DESC";
    }

    public static final class Threads implements BaseColumns {
        private Threads() {}

        public static final Uri CONTENT_URI = Uri.parse("content://"
                + MessagesProvider.AUTHORITY + "/threads");

        /**
         * Builds a thread {@link Uri}.
         * @param peer the peer of the thread
         * @return a new thread {@link Uri}
         */
        public static Uri getUri(String peer) {
            return Uri.parse("content://"
                    + MessagesProvider.AUTHORITY + "/threads/" + Uri.encode(peer));
        }

        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/org.kontalk.thread";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/org.kontalk.thread";

        public static final String MESSAGE_ID = "msg_id";
        public static final String PEER = "peer";
        public static final String DIRECTION = "direction";
        public static final String COUNT = "count";
        public static final String UNREAD = "unread";
        public static final String MIME = "mime";
        public static final String CONTENT = "content";
        public static final String TIMESTAMP = "timestamp";
        public static final String STATUS_CHANGED = "status_changed";
        public static final String STATUS = "status";

        public static final String DEFAULT_SORT_ORDER = "timestamp DESC";
        public static final String INVERTED_SORT_ORDER = "timestamp";
    }
}
