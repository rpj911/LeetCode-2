				surveyTrainSet = meta.newQuery().in(meta.BLOGID, blogIds).getArrayList();
				
				
				meta.newQuery().join(meta.BLOG).join(LogEntry.META.blog).eq(LogEntry.META.EVENT, RespInvLogEvent.ALERT_ASSIGNED).getArrayList();
				




				SurveyField sf = null;
				AlternativeSet as = sf.getAlternativeSet();
				if (as.isEnumerated()) {
					List<AlternativeDb> numeric = sf.getAlternativeSet().getNumericAlternativeDbs();
					if (!numeric.isEmpty()) {
						
					}
					
				}
				
				
				new SingleStageSurveyDbStreamLoader(LOG, "alert assigned surveys", company) {
					@Override protected Iterable<? extends Survey> getStreamIterable() {
						return meta.newQuery().join(meta.BLOG).join(LogEntry.META.blog).eq(LogEntry.META.EVENT, RespInvLogEvent.ALERT_ASSIGNED).prepareStreaming();
					}

					@Override protected void doAction(List<Survey> batch) {
						
						
						// TODO Auto-generated method stub
						
					}
				};




								//
				SurveyAggregateField aField = SurveyAggregateField.ALERT_ASSIGNED_TO_GROUPS;
				if (!aField.getValues(survey).isEmpty() ) {
					
				}