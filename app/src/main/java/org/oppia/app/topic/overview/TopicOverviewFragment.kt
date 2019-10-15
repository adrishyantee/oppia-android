package org.oppia.app.topic.overview

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.oppia.app.fragment.InjectableFragment
import javax.inject.Inject

/** Fragment that contains overview of Topic. */
class TopicOverviewFragment : InjectableFragment(), TopicDownloadListener, TopicDeleteListener {
  @Inject
  lateinit var topicOverviewFragmentPresenter: TopicOverviewFragmentPresenter

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    fragmentComponent.inject(this)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return topicOverviewFragmentPresenter.handleCreateView(inflater, container)
  }

  override fun downloadTopicWhileOnCellular(saveUserChoice: Boolean) {
    topicOverviewFragmentPresenter.handleDownloadTopic(saveUserChoice)
  }

  override fun doNotDownloadTopicWhileOnCellular(saveUserChoice: Boolean) {
    topicOverviewFragmentPresenter.handleDoNotDownloadTopic(saveUserChoice)
  }

  override fun deleteTopic() {
    topicOverviewFragmentPresenter.handleDeleteTopic()
  }
}
